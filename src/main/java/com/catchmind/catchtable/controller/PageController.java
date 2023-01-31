package com.catchmind.catchtable.controller;

import com.catchmind.catchtable.domain.Profile;
import com.catchmind.catchtable.dto.ProfileDto;
import com.catchmind.catchtable.dto.network.ProfileRequest;
import com.catchmind.catchtable.service.ProfileLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Stream;
@RequiredArgsConstructor
@Controller
@RequestMapping("")
public class PageController {

    private final PasswordEncoder passwordEncoder;
    private final ProfileLogicService profileLogicService;

    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @GetMapping("join")
    public ModelAndView join() {
        return new ModelAndView("/join");
    }

    @PostMapping("/join")
    public String join(ProfileRequest request, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "join";
        }
        try{
            Profile profile = Profile.createMember(request, passwordEncoder);
            profileLogicService.saveMember(profile);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage",e.getMessage());
            return "join";
        }
        return "redirect:/";
    }
}
