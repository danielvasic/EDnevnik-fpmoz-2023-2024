package ba.sum.fpmoz.ednevnikfpmoz20232024.controllers;

import ba.sum.fpmoz.ednevnikfpmoz20232024.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ba.sum.fpmoz.ednevnikfpmoz20232024.repositories.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(){
        return "redirect:/user";
    }

    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

    @PostMapping("/user")
    public String addUser(User user){
        userRepository.save(user);
        return "redirect:/user";
    }

}
