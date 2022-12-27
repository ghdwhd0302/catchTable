package com.catchmind.catchtable.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("feed")
public class Feed {

    @GetMapping(path="feedMain")   // http://localhost:8888/feed/feedMain
    public ModelAndView feedMain() {
        return new ModelAndView("/feedMain");
    }

    @GetMapping(path="feedDetail")   // http://localhost:8888/feed/feedDetail
    public ModelAndView feedDetail() {
        return new ModelAndView("/feedDetail");
    }

    @GetMapping(path="tabFeedFollower")   // http://localhost:8888/feed/tabFeedFollower
    public ModelAndView tabFeedFollower() {
        return new ModelAndView("/tabFeedFollower");
    }

    @GetMapping(path="replyList")   // http://localhost:8888/feed/replyList
    public ModelAndView replyList() {
        return new ModelAndView("/replyList");
    }

}
