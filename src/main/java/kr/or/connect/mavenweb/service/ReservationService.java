package kr.or.connect.mavenweb.service;

import kr.or.connect.mavenweb.dto.reservation.ReservationInfoResponse;
import kr.or.connect.mavenweb.dto.reservation.ReservationParam;
import kr.or.connect.mavenweb.dto.reservation.ReservationResponse;

import java.text.SimpleDateFormat;
import java.util.Map;

public interface ReservationService {
    public static final SimpleDateFormat reservationDateformat = new SimpleDateFormat("yyyy.MM.dd");

    public ReservationInfoResponse getReservationInfoResponse(String reservationEmail);

    public ReservationResponse makeReservation(ReservationParam reservationParam);

    public ReservationResponse deleteReservationInfo(int reservationInfoId);

    public Map<String, Object> getReservationInfoByTime(String reservationEmail);

    public Integer updateReservationInfoCancel(int reservationInfoId);
}
