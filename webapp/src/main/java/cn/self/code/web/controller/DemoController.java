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

    /**
     * 分栏阴影
     * @return
     */
    @RequestMapping("shadowPage.jhtml")
    public ModelAndView shadowPage(){
        ModelAndView mav = new ModelAndView("/demo/shadow");
        return mav;
    }
}
