package com.catchmind.catchtable.controller.page;

import com.catchmind.catchtable.service.ProfileLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class PageController {

    @Autowired
    private ProfileLogicService profileLogicService;

    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @GetMapping("login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @PostMapping(path="/loginOk")   // http://localhost:8889/loginOk
    public String loginOk(HttpServletRequest request, String prHp, String prUserpw){
        if(profileLogicService.read(prHp, prUserpw).getData() != null){
            HttpSession session = request.getSession();
            Long prIdx = profileLogicService.read(prHp, prUserpw).getData().getPrIdx();
            session.setAttribute("prIdx", prIdx);
            session.setAttribute("prHp", prHp);
            return "redirect:/index";
        }else{
            return "redirect:/login";
        }
    }

    @GetMapping("join")
    public ModelAndView join() {
        return new ModelAndView("/join");
    }
}
