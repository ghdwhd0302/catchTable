package com.catchmind.catchtable.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("collection")
public class Collection {

    @GetMapping(path="list")   // http://localhost:8888/collection/list
    public ModelAndView collectionList() {
        return new ModelAndView("/collectionList");
    }

    @GetMapping(path="detail")   // http://localhost:8888/collection/detail
    public ModelAndView collectionDetail() {
        return new ModelAndView("/collectionDetail");
    }

    @GetMapping(path="collectionForm")   // http://localhost:8888/collection/detail
    public ModelAndView collectionForm() {
        return new ModelAndView("/collectionForm");
    }


    @GetMapping(path="addRestaurant")   // http://localhost:8888/collection/addRestaurant
    public ModelAndView addRestaurant() {
        return new ModelAndView("/addRestaurant");
    }

    @GetMapping(path="collectionModify")   // http://localhost:8888/collection/collectionModify
    public ModelAndView collectionModify() {
        return new ModelAndView("/collectionModify");
    }



}
