package com.huntdreams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Created by noprom on 10/23/15.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public String users(ModelMap model, @PathVariable String user) {
        model.addAttribute("user", user);
        return "user";
    }

}
