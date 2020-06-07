package kr.or.connect.mavenweb.dto.reservation;

import java.util.List;

public class ReservationResponse {
    private Boolean cancelYn;
    private String createDate;
    private Integer displayInfoId;
    private String modifyDate;
    private List<ReservationPrice> prices;
    private Integer productId;
    private String reservationDate;
    private String reservationEmail;
    private Integer reservationInfoId;
    private String reservationName;
    private String reservationTelephone;

    public ReservationResponse() {
    }

    public ReservationResponse(Boolean cancelYn, String createDate, Integer displayInfoId, String modifyDate, List<ReservationPrice> prices, Integer productId, String reservationDate, String reservationEmail, Integer reservationInfoId, String reservationName, String reservationTelephone) {
        this.cancelYn = cancelYn;
        this.createDate = createDate;
        this.displayInfoId = displayInfoId;
        this.modifyDate = modifyDate;
        this.prices = prices;
        this.productId = productId;
        this.reservationDate = reservationDate;
        this.reservationEmail = reservationEmail;
        this.reservationInfoId = reservationInfoId;
        this.reservationName = reservationName;
        this.reservationTelephone = reservationTelephone;
    }

    public ReservationResponse(ReservationInfo reservationInfo, List<ReservationPrice> reservationPrices) {
        this.cancelYn = reservationInfo.getCancelYn();
        this.createDate = reservationInfo.getCreateDate();
        this.displayInfoId = reservationInfo.getDisplayInfoId();
        this.modifyDate = reservationInfo.getModifyDate();
        this.prices = reservationPrices;
        this.productId = reservationInfo.getProductId();
        this.reservationDate = reservationInfo.getReservationDate();
        this.reservationEmail = reservationInfo.getReservationEmail();
        this.reservationInfoId = reservationInfo.getReservationInfoId();
        this.reservationName = reservationInfo.getReservationName();
        this.reservationTelephone = reservationInfo.getReservationTelephone();
    }

    @Override
    public String toString() {
        return "ReservationResponse{"+
                "cancelYn="+cancelYn+
                ", createDate='"+createDate+'\''+
                ", displayInfoId="+displayInfoId+
                ", modifyDate='"+modifyDate+'\''+
                ", prices="+prices+
                ", productId="+productId+
                ", reservationDate='"+reservationDate+'\''+
                ", reservationEmail='"+reservationEmail+'\''+
                ", reservationInfoId="+reservationInfoId+
                ", reservationName='"+reservationName+'\''+
                ", reservationTelephone='"+reservationTelephone+'\''+
                '}';
    }

    public Boolean getCancelYn() {
        return cancelYn;
    }

    public void setCancelYn(Boolean cancelYn) {
        this.cancelYn = cancelYn;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(Integer displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public List<ReservationPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ReservationPrice> prices) {
        this.prices = prices;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public Integer getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(Integer reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationTelephone() {
        return reservationTelephone;
    }

    public void setReservationTelephone(String reservationTelephone) {
        this.reservationTelephone = reservationTelephone;
    }
}
