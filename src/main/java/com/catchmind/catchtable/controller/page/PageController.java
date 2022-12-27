package com.catchmind.catchtable.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class PageController {

    @GetMapping(path = "")
    public ModelAndView index() { return new ModelAndView("/index"); }


    @GetMapping(path = "login")   // http://localhost:8888/login
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @GetMapping(path = "join")   // http://localhost:8888/login
    public ModelAndView join() {
        return new ModelAndView("/join");
    }

    @GetMapping(path = "search")   // http://localhost:8888/search
    public ModelAndView search() {
        return new ModelAndView("/search");
    }

    @GetMapping(path = "search/list")   // http://localhost:8888/search/list
    public ModelAndView list() {
        return new ModelAndView("/list");
    }


    @GetMapping(path = "reservation")   // http://localhost:8888/reservation
    public ModelAndView reservation() {
        return new ModelAndView("/reservation");
    }

    @GetMapping(path = "review/Profile")   // http://localhost:8888/review/Profile
    public ModelAndView review() {
        return new ModelAndView("/reviewProfile");
    }

    @GetMapping(path = "magazine/Magazine17")   // http://localhost:8888/magazine
    public ModelAndView magazine() {
        return new ModelAndView("/magazine");
    }

    @GetMapping(path = "reservation/detail")   // http://localhost:8888/reservation/detail
    public ModelAndView reservationDetail() {
        return new ModelAndView("/reservationDetail");
    }


    @GetMapping(path="emptySlotMain")   // http://localhost:8888/emptySlot
    public ModelAndView emptySlot() {
        return new ModelAndView("emptySlotMain");
    }

    @GetMapping(path="emptySlotGuide")   // http://localhost:8888/emptySlot
    public ModelAndView emptySlotGuide() {
        return new ModelAndView("emptySlotGuide");
    }






}

























