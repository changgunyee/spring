package kr.or.connect.mavenweb.controller;


import kr.or.connect.mavenweb.dto.User;
import kr.or.connect.mavenweb.service.ProductService;
import kr.or.connect.mavenweb.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@SessionAttributes("user")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    private ProductService productService;

    @GetMapping(path = "/myreservation")
    public String renderMyReservationPage(@RequestParam(name = "resrv_email", required = false) String email, @ModelAttribute("user") User user, ModelMap modelMap) {
        Map<String, Object> reservationInfos;
        if (user.getEmail() != null) {
            reservationInfos = reservationService.getReservationInfoByTime(user.getEmail());
            modelMap.putAll(reservationInfos);
            return "myreservation";
        } else {
            reservationInfos = reservationService.getReservationInfoByTime(email);
            int size = (int) reservationInfos.get("size");
            if (size > 0) {
                user.setEmail(email);
                modelMap.putAll(reservationInfos);
                return "myreservation";
            }
        }
        return "redirect:/bookinglogin";
    }

    @GetMapping(path = "/reserve")
    public String renderReservePage(@RequestParam(name = "id") int displayInfoId, ModelMap modelMap) {
        modelMap.putAll(productService.getDetailDisplayInfo(displayInfoId));
        return "reserve";
    }

    @GetMapping(path = "/bookinglogin")
    public String renderLoginPage(@ModelAttribute("user") User user, HttpSession session) {
        if (user.getEmail() == null) {
            return "bookinglogin";
        }
        return "redirect:/myreservation";
    }

    @ModelAttribute("user")
    public User setUser() {
        return new User();
    }
}
