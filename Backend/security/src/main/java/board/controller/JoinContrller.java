package board.controller;

import board.dto.JoinDto;
import board.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinContrller {
    @Autowired
    JoinService joinService;

    @GetMapping("/join")
    public String join() {
        return "/join";
    }

    @PostMapping("/joinProc")
    public String joinProc(JoinDto joinDto) {
        if (joinService.joinProcess(joinDto)) {
            return "redirect:/login";
        } else {
            return "redirect:/join";
        }
    }
}
