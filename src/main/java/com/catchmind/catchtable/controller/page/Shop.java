package com.catchmind.catchtable.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("shop")
public class Shop {

    @GetMapping(path="")   // http://localhost:8888/shop
    public ModelAndView shop() {
        return new ModelAndView("/shop");
    }

    @GetMapping(path="menuAllList")   // http://localhost:8888/shop/menuAllList
    public ModelAndView menuAllList() {
        return new ModelAndView("/menuAllList");
    }

    @GetMapping(path="shopPhotoList")   // http://localhost:8888/shop/shopPhotoList
    public ModelAndView shopPhotoList() {
        return new ModelAndView("/shopPhotoList");
    }

    @GetMapping(path="review")   // http://localhost:8888/shop/review
    public ModelAndView shopReview() {
        return new ModelAndView("/shopReview");
    }

    @GetMapping(path="/reportReview")   // http://localhost:8888/shop/reportReview
    public ModelAndView reportReview() {
        return new ModelAndView("/reportReview");
    }

    @GetMapping(path="shop/mainNoticeDetail")   // http://localhost:8888/shop/mainNoticeDetail
    public ModelAndView mainNoticeDetail() {
        return new ModelAndView("/mainNoticeDetail");
    }
}
