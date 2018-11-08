package cn.self.code.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhaoliang on 2018/11/8.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("test")
    public ModelAndView testPage(){
        ModelAndView mav = new ModelAndView("/user/test");
        return mav;
    }
}
