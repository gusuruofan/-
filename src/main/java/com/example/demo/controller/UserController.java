package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    // 根据条件查询用户信息
    // kw: 查询关键字，即条件
    // model: 模型对象，也是视图（界面）的上下文环境对象
    // pageable: 分页信息对象，包含了分页需要的基本信息，如当前页码，每页需要的条数
    // return: 字符串，代表了界面文件
    @Autowired
    private UserService userService;

    @RequestMapping("/listusers")
    public String List(String kw, Model model, Pageable pageable) {
        if (kw == null) {
            kw = "%%";
        } else {
            kw = "%" + kw + "%";
        }
        Page<User> ppu = userService.findAll(kw, pageable);
        model.addAttribute("pages", ppu);
        return "listusers";
    }

    @GetMapping({"/edituser", "/edituser/{uid}"})
    public String edit(@PathVariable(name = "uid", required = false) Integer uid, Model model) {
        User u = new User();
        if (uid != null && uid > 0) {
            u = userService.findById(uid);
        }
        model.addAttribute("user", u);
        return "edituser";
    }

    // 存储，采用post请求
    @PostMapping("/saveuser")
    public String save(@Validated User user, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/edituser";
        }
        userService.save(user);
        return "redirect:/listusers";
    }

    // 删除用户，采用Get请求
    @GetMapping("/delete/{uid}")
    public String delete(@PathVariable("uid") Integer uid) {
        userService.deleteById(uid);
        return "redirect:/listusers";
    }

    // 让用户失效，使用Get请求
    @GetMapping("/validuser/{uid}")
    public String validuser(@PathVariable("uid") Integer uid) {
        User user = userService.findById(uid);
        if (user.getValidState() == 0) user.setValidState(1);
        if (user.getValidState() == 1) user.setValidState(0);
        return "redirect:/listusers";
    }
}