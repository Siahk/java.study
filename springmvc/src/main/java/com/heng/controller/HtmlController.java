package com.heng.controller;

import com.heng.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HtmlController {
    @GetMapping(value = "/index")
    public String index() {
        System.out.println("success");
        return "/index";
    }

    /**
     *
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
        if (id != null) {
            User user = new User(1, "TOM", "123456","a@heng.com", 12);
            System.out.println(user);
            map.put("user", user);
        }
    }
    @ResponseBody
    @RequestMapping("/testModelAttribute")
    public User testModelAttribute(User abc) {
        System.out.println("修改：" + abc);
        return abc;
    }
}