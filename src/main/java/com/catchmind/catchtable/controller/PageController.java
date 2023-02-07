package com.catchmind.catchtable.controller;

import com.catchmind.catchtable.domain.Profile;
import com.catchmind.catchtable.dto.network.request.ProfileRequest;
import com.catchmind.catchtable.dto.network.response.TimeLineResponse;
import com.catchmind.catchtable.dto.security.CatchPrincipal;
import com.catchmind.catchtable.service.ProfileLogicService;
import com.catchmind.catchtable.service.TimeLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("")
public class PageController {

    private final PasswordEncoder passwordEncoder;
    private final ProfileLogicService profileLogicService;
    private final TimeLineService timeLineService;

    // 마이페이지 헤더
    public TimeLineResponse header(Long prIdx) {
        TimeLineResponse response = timeLineService.getHeader(prIdx);
        return response;
    }
    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @GetMapping("/newSNS")
    public ModelAndView SNS(@AuthenticationPrincipal CatchPrincipal catchPrincipal,
                            Model model){
        Long prIdx = catchPrincipal.prIdx();
        model.addAttribute("prIdx",prIdx);
        return new ModelAndView("/newSNS");
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

    @PostMapping("/idCheck")
    @ResponseBody
    public boolean nickCheck(@RequestParam("prNick")String prNick){
        Optional<Profile> profile = profileLogicService.checkNick(prNick);
        if (profile.isEmpty()){
            return true;
        }else {
            return false;
        }
    }


    @GetMapping("/pending")
    public ModelAndView inquiry (){
        return new ModelAndView("/inquiry");
    }


}
