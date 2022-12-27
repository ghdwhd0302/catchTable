package com.catchmind.catchtable.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("my")
public class MyPageController {
    @GetMapping(path="myMain")   // http://localhost:8888/my/myMain
    public ModelAndView myMain() {
        return new ModelAndView("/myMain");
    }

    @GetMapping(path="myMain/review")   // http://localhost:8888/my/myMain/review
    public ModelAndView myMainReview() {return new ModelAndView("/myMainReview");}

    @GetMapping(path="myInfo")   // http://localhost:8888/my/myInfo
    public ModelAndView myInfo() {
        return new ModelAndView("/myInfo");
    }

    @GetMapping(path="myInfoModify")   // http://localhost:8888/my/myInfoModify
    public ModelAndView myInfoModify() {
        return new ModelAndView("/myInfoModify");
    }

    @GetMapping(path="myInfoEdit/name")   // http://localhost:8888/my/myInfoEdit/name
    public ModelAndView myInfoEditName() {
        return new ModelAndView("/myInfoEditName");
    }

    @GetMapping(path="myInfoEdit/phoneNumber")   // http://localhost:8888/my/myInfoEdit/phoneNumber
    public ModelAndView myInfoEditPhoneNumber() {
        return new ModelAndView("/myInfoEditPhoneNumber");
    }

    @GetMapping(path="support/feedback")   // http://localhost:8888/my/support/feedback
    public ModelAndView supportFeddback() {
        return new ModelAndView("/supportFeedback");
    }

    @GetMapping(path="support/main")   // http://localhost:8888/my/support/main
    public ModelAndView supportMain() {
        return new ModelAndView("/supportMain");
    }

    @GetMapping(path="support/supportSubPolicy")   // http://localhost:8888/my/support/supportSubPolicy
    public ModelAndView supportSubPolicy() {return new ModelAndView("/supportSubPolicy");}

    @GetMapping(path="support/supportSubPolicy/tmp")   // http://localhost:8888/my/support/main
    public ModelAndView supportSubPolicyTmp() {return new ModelAndView("supportSubPolicyTmp");}

    @GetMapping(path="savedShopList")   // http://localhost:8888/my/savedShopList
    public ModelAndView savedShopList() {
        return new ModelAndView("/savedShopList");
    }









}
