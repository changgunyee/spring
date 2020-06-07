package kr.or.connect.mavenweb.controller.api;

import kr.or.connect.mavenweb.dto.reservation.ReservationInfoResponse;
import kr.or.connect.mavenweb.dto.reservation.ReservationParam;
import kr.or.connect.mavenweb.dto.reservation.ReservationResponse;
import kr.or.connect.mavenweb.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/reservations")
public class ReservationApiController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public ReservationInfoResponse getReservationInfoResponse(@RequestParam(name = "reservationEmail") String reservationEmail, ModelMap modelMap) {
        return reservationService.getReservationInfoResponse(reservationEmail);
    }

    @PostMapping
    public ReservationResponse makeReservation(@RequestBody ReservationParam reservationParam) {
        return reservationService.makeReservation(reservationParam);
    }

    @PutMapping("/{id}")
    public ReservationResponse deleteReservation(@PathVariable(name = "id") Integer reservationInfoId) {
        return reservationService.deleteReservationInfo(reservationInfoId);
    }

    @PutMapping("/cancel/{id}")
    public int cancelReservation(@PathVariable(name = "id") Integer reservationInfoId) {
        return reservationService.updateReservationInfoCancel(reservationInfoId);
    }
}
