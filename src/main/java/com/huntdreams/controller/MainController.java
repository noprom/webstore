package com.huntdreams.controller;

import com.huntdreams.model.UserEntity;
import com.huntdreams.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by noprom on 10/23/15.
 */
@Controller
public class MainController {

    // 自动装配
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    // 用户管理
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap modelMap) {
        // 找到user表里的所有记录
        List<UserEntity> userList = userRepository.findAll();
        // 将所有记录传递给返回的jsp页面
        modelMap.addAttribute("userList", userList);
        // 返回 pages 目录下的 userManage.jsp 页面
        return "usermanage";
    }

    // 添加用户 页面
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        return "addUser";
    }

    // 添加用户 处理
    @RequestMapping(value = "/addUserPost", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity) {

        // 数据库中添加一个用户
        //userRepository.save(userEntity);


        // 数据库中添加一个用户，并立即刷新
        userRepository.saveAndFlush(userEntity);


        // 返回重定向 到 /users 请求
        return "redirect:/users";
    }
}
