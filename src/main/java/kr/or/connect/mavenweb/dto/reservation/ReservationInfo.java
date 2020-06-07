package kr.or.connect.mavenweb.dto.reservation;

import kr.or.connect.mavenweb.dto.product.DisplayInfo;


public class ReservationInfo {
    private Boolean cancelYn;
    private String createDate;
    private DisplayInfo displayInfo;
    private Integer displayInfoId;
    private Integer productId;
    private String reservationDate;
    private String reservationEmail;
    private Integer reservationInfoId;
    private String reservationName;
    private String reservationTelephone;
    private Integer totalPrice;
    private String modifyDate;


    public ReservationInfo() {
    }

    public ReservationInfo(Boolean cancelYn, String createDate, DisplayInfo displayInfo, Integer displayInfoId, Integer productId, String reservationDate, String reservationEmail, Integer reservationInfoId, String reservationName, String reservationTelephone, Integer totalPrice, String modifyDate) {
        this.cancelYn = cancelYn;
        this.createDate = createDate;
        this.displayInfo = displayInfo;
        this.displayInfoId = displayInfoId;
        this.productId = productId;
        this.reservationDate = reservationDate;
        this.reservationEmail = reservationEmail;
        this.reservationInfoId = reservationInfoId;
        this.reservationName = reservationName;
        this.reservationTelephone = reservationTelephone;
        this.totalPrice = totalPrice;
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "ReservationInfo{"+
                "cancelYn="+cancelYn+
                ", createDate='"+createDate+'\''+
                ", displayInfo="+displayInfo+
                ", displayInfoId="+displayInfoId+
                ", productId="+productId+
                ", reservationDate='"+reservationDate+'\''+
                ", reservationEmail='"+reservationEmail+'\''+
                ", reservationInfoId="+reservationInfoId+
                ", reservationName='"+reservationName+'\''+
                ", reservationTelephone='"+reservationTelephone+'\''+
                ", totalPrice="+totalPrice+
                ", modifyDate='"+modifyDate+'\''+
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

    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    public void setDisplayInfo(DisplayInfo displayInfo) {
        this.displayInfo = displayInfo;
    }

    public Integer getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(Integer displayInfoId) {
        this.displayInfoId = displayInfoId;
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

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
}