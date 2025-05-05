package si.um.feri.controller;

import si.um.feri.model.User;
import si.um.feri.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/vulnerable")
    public String showVulnerableForm(Model model) {
        model.addAttribute("tab", "vulnerable");
        return "index";
    }

    @PostMapping("/vulnerable")
    public String postVulnerable(@RequestParam String input, Model model) {
        List<User> results = userRepository.findByUsernameUnsafe(input);
        model.addAttribute("results", results);
        model.addAttribute("tab", "vulnerable");
        return "index";
    }

    @GetMapping("/secure")
    public String showSecureForm(Model model) {
        model.addAttribute("tab", "secure");
        return "index";
    }

    @PostMapping("/secure")
    public String postSecure(@RequestParam String input, Model model) {
        List<User> results = userRepository.findByUsername(input);
        model.addAttribute("results", results);
        model.addAttribute("tab", "secure");
        return "index";
    }
}
