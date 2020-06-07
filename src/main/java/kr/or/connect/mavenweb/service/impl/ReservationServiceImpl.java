package kr.or.connect.mavenweb.service.impl;

import kr.or.connect.mavenweb.dao.ProductDao;
import kr.or.connect.mavenweb.dao.ReservationDao;
import kr.or.connect.mavenweb.dto.reservation.*;
import kr.or.connect.mavenweb.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public ReservationInfoResponse getReservationInfoResponse(String reservationEmail) {
        List<ReservationInfo> reservationInfos = reservationDao.selectReservationInfoByEmail(reservationEmail);
        for (ReservationInfo reservationInfo : reservationInfos) {
            reservationInfo.setDisplayInfo(productDao.selectDisplayInfo(reservationInfo.getDisplayInfoId()));
        }

        ReservationInfoResponse reservationInfoResponse = new ReservationInfoResponse(reservationInfos, reservationInfos.size());
        return reservationInfoResponse;
    }

    @Override
    public Map<String, Object> getReservationInfoByTime(String reservationEmail) {
        List<ReservationInfo> reservationInfos = reservationDao.selectReservationInfoByEmail(reservationEmail);

        List<ReservationInfo> confirmedReservationInfos = new ArrayList<>();
        List<ReservationInfo> usedReservationInfos = new ArrayList<>();
        List<ReservationInfo> canceledReservationInfos = new ArrayList<>();

        for (ReservationInfo reservationInfo : reservationInfos) {
            reservationInfo.setDisplayInfo(productDao.selectDisplayInfo(reservationInfo.getDisplayInfoId()));
            LocalDateTime now = LocalDateTime.now();
            if (reservationInfo.getCancelYn()) {
                canceledReservationInfos.add(reservationInfo);
            } else if (now.isBefore(LocalDateTime.parse(reservationInfo.getReservationDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")))) {
                confirmedReservationInfos.add(reservationInfo);
            } else {
                usedReservationInfos.add(reservationInfo);
            }
        }

        Map<String, Object> reservationInfoByTime = new HashMap<>();
        reservationInfoByTime.put("confirmedReservationInfos", confirmedReservationInfos);
        reservationInfoByTime.put("usedReservationInfos", usedReservationInfos);
        reservationInfoByTime.put("canceledReservationInfos", canceledReservationInfos);
        reservationInfoByTime.put("size", reservationInfos.size());
        return reservationInfoByTime;
    }


    @Override
    @Transactional
    public ReservationResponse makeReservation(ReservationParam reservationParam) {
        String date = LocalDate.parse(reservationParam.getReservationYearMonthDay(), DateTimeFormatter.ofPattern("yyyy.MM.dd")).atStartOfDay().toString();
        ReservationInfo reservationInfo = new ReservationInfo(false, date, null, reservationParam.getDisplayInfoId(), reservationParam.getProductId(), date, reservationParam.getReservationEmail(), null, reservationParam.getReservationName(), reservationParam.getReservationTelephone(), null, date);
        Integer reservationInfoKey = reservationDao.insertReservationInfo(reservationInfo);

        for (ReservationPrice reservationPrice : reservationParam.getPrices()) {
            reservationPrice.setReservationInfoId(reservationInfoKey);
            Integer reservationPriceKey = reservationDao.insertReservationPrice(reservationPrice);

            if (reservationPriceKey == null) {
                return null;
            }
            reservationPrice.setReservationInfoPriceId(reservationPriceKey);
        }
        return new ReservationResponse(reservationInfo, reservationParam.getPrices());
    }

    @Override
    @Transactional
    public ReservationResponse deleteReservationInfo(int reservationInfoId) {
        ReservationInfo reservationInfo = reservationDao.selectReservationInfoById(reservationInfoId);
        List<ReservationPrice> reservationPrices = reservationDao.selectReservationPrices(reservationInfoId);

        reservationDao.deleteReservationPrice(reservationInfoId);
        reservationDao.deleteReservationUserComment(reservationInfoId);
        reservationDao.deleteReservationInfo(reservationInfoId);

        return new ReservationResponse(reservationInfo, reservationPrices);
    }

    @Override
    public Integer updateReservationInfoCancel(int reservationInfoId) {
        return reservationDao.updateReservationInfoCancel(reservationInfoId);
    }
}
