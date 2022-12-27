package com.catchmind.catchtable.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("mydining")
public class MyDining {
    @GetMapping(path="planned")   // http://localhost:8888/mydining/planned
    public ModelAndView planned() {
        return new ModelAndView("/planned");
    }

    @GetMapping(path="done")   // http://localhost:8888/mydining/done
    public ModelAndView done() {
        return new ModelAndView("/done");
    }

    @GetMapping(path="cancel")   // http://localhost:8888/mydining/cancel
    public ModelAndView cancel() {
        return new ModelAndView("/cancel");
    }

    @GetMapping(path="emptySlot")   // http://localhost:8888/mydining/emptySlot
    public ModelAndView emptySlot() {
        return new ModelAndView("/emptySlot");
    }

    

    @GetMapping(path="emptySlotGuide")   // http://localhost:8888/mydining/emptySlotGuide
    public ModelAndView emptySlotGuide() {
        return new ModelAndView("emptySlotGuide");
    }



}
