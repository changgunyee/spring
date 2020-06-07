package kr.or.connect.mavenweb.dto.reservation;

import java.util.List;

public class ReservationInfoResponse {
    private List<ReservationInfo> reservations;
    private Integer size;

    public ReservationInfoResponse() {
    }

    public ReservationInfoResponse(List<ReservationInfo> reservations, Integer size) {
        this.reservations = reservations;
        this.size = size;
    }

    @Override
    public String toString() {
        return "ReservationInfoResponse{"+
                "reservations="+reservations+
                ", size="+size+
                '}';
    }

    public List<ReservationInfo> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationInfo> reservations) {
        this.reservations = reservations;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
