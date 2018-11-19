package cn.self.code.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhaoliang on 2018/11/16.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("navHeader.jhtml")
    public ModelAndView navHeaderPage(){
        ModelAndView mav = new ModelAndView("/demo/navHeader");
        return mav;
    }
}
