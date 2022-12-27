package com.catchmind.catchtable.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("notice")
public class Notice {
    @GetMapping(path="")
    public ModelAndView notice() {return new ModelAndView("/notice");}

    @GetMapping(path="content")
    public ModelAndView content() {return new ModelAndView("/noticeContent");}

}
