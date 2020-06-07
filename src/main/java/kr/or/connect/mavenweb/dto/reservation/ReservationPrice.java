package kr.or.connect.mavenweb.dto.reservation;

public class ReservationPrice {
    private Integer count;
    private Integer productPriceId;
    private Integer reservationInfoId;
    private Integer reservationInfoPriceId;

    public ReservationPrice() {
    }

    public ReservationPrice(Integer count, Integer productPriceId, Integer reservationInfoId, Integer reservationInfoPriceId) {
        this.count = count;
        this.productPriceId = productPriceId;
        this.reservationInfoId = reservationInfoId;
        this.reservationInfoPriceId = reservationInfoPriceId;
    }

    @Override
    public String toString() {
        return "ReservationPrice{"+
                "count="+count+
                ", productPriceId="+productPriceId+
                ", reservationInfoId="+reservationInfoId+
                ", reservationInfoPriceId="+reservationInfoPriceId+
                '}';
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(Integer productPriceId) {
        this.productPriceId = productPriceId;
    }

    public Integer getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(Integer reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public Integer getReservationInfoPriceId() {
        return reservationInfoPriceId;
    }

    public void setReservationInfoPriceId(Integer reservationInfoPriceId) {
        this.reservationInfoPriceId = reservationInfoPriceId;
    }
}
