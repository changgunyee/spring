package kr.or.connect.mavenweb.dao;

import kr.or.connect.mavenweb.dto.reservation.ReservationInfo;
import kr.or.connect.mavenweb.dto.reservation.ReservationPrice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.mavenweb.dao.ReservationDaoSqls.*;


@Repository
public class ReservationDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ReservationInfo> reservationInfoRowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
    private RowMapper<ReservationPrice> reservationPriceRowMapper = BeanPropertyRowMapper.newInstance(ReservationPrice.class);
    private SimpleJdbcInsert reservationInfoInsertAction;
    private SimpleJdbcInsert reservationPriceInsertAction;

    public ReservationDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.reservationInfoInsertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info")
                .usingGeneratedKeyColumns("id");
        this.reservationPriceInsertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info_price")
                .usingGeneratedKeyColumns("id");
    }

    public List<ReservationInfo> selectReservationInfoByEmail(String reservationEmail) {
        return jdbc.query(SELECT_RESERVATION_INFOS_BY_EMAIL, Collections.singletonMap("reservationEmail", reservationEmail), reservationInfoRowMapper);
    }

    public ReservationInfo selectReservationInfoById(int reservationInfoId) {
        return jdbc.queryForObject(SELECT_RESERVATION_INFO_BY_ID, Collections.singletonMap("reservationInfoId", reservationInfoId), reservationInfoRowMapper);
    }

    public Integer insertReservationInfo(ReservationInfo reservationInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("product_id", reservationInfo.getProductId());
        params.put("display_info_id", reservationInfo.getDisplayInfoId());
        params.put("reservation_name", reservationInfo.getReservationName());
        params.put("reservation_tel", reservationInfo.getReservationTelephone());
        params.put("reservation_email", reservationInfo.getReservationEmail());
        params.put("reservation_date", LocalDateTime.parse(reservationInfo.getReservationDate()));
        params.put("cancel_flag", reservationInfo.getCancelYn());
        params.put("create_date", LocalDateTime.parse(reservationInfo.getCreateDate()));
        params.put("modify_date", LocalDateTime.parse(reservationInfo.getModifyDate()));

        return reservationInfoInsertAction.executeAndReturnKey(params).intValue();
    }

    public List<ReservationPrice> selectReservationPrices(int reservationInfoId) {
        return jdbc.query(SELECT_RESERVATION_INFO_PRICE, Collections.singletonMap("reservationInfoId", reservationInfoId), reservationPriceRowMapper);
    }

    public Integer insertReservationPrice(ReservationPrice reservationPrice) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservationPrice);
        return reservationPriceInsertAction.executeAndReturnKey(params).intValue();
    }

    public Integer deleteReservationInfo(int reservationInfoId) {
        return jdbc.update(DELETE_RESERVATION_INFO, Collections.singletonMap("reservationInfoId", reservationInfoId));
    }

    public Integer deleteReservationPrice(int reservationInfoId) {
        return jdbc.update(DELETE_RESERVATION_INFO_PRICE, Collections.singletonMap("reservationInfoId", reservationInfoId));
    }

    public Integer deleteReservationUserComment(int reservationInfoId) {
        return jdbc.update(DELETE_RESERVATION_USER_COMMENT, Collections.singletonMap("reservationInfoId", reservationInfoId));
    }

    public Integer updateReservationInfoCancel(int reservationInfoId) {
        return jdbc.update(UPDATE_RESERVATION_INFO_CANCEL, Collections.singletonMap("reservationInfoId", reservationInfoId));
    }
}
