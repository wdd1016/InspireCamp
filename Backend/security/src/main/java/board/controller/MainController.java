package board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(@RequestParam(value = "accessDenied", required = false) String accessDenied, Model model) {
        if ("true".equals(accessDenied)) {
            model.addAttribute("errorMessage", "해당 페이지에 접근할 권한이 없습니다.");
        }
        return "/index";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }
}
