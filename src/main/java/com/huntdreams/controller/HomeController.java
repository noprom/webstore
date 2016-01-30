package com.huntdreams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主页控制器
 * Created by noprom on 10/23/15.
 */
@Controller
public class HomeController {

    /**
     * 跟目录
     * @return 视图
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * 欢迎界面
     * @param model model
     * @return 视图
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
//        model.addAttribute("welcome", "welcome");
//        return "forward:/welcome/greeting";
        return "redirect:/welcome/greeting";
    }

    /**
     * 欢迎界面
     * @param model model
     * @return 视图
     */
    @RequestMapping(value = "/welcome/greeting", method = RequestMethod.GET)
    public String greeting(Model model) {
        model.addAttribute("welcome", "welcome");
        return "welcome";
    }
}