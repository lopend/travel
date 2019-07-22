package com.baize.travel.web.controller;


import com.baize.travel.domain.User;
import com.baize.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @crete 2019/7/22
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService ;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login" ;
    }

    @RequestMapping("/register")
    public String goRegister(){
        return "register" ;
    }

    @RequestMapping("/checkLogin")
    public  String checkLogin(User user,HttpServletRequest req, HttpServletResponse resp){
        Integer rSet = userService.checkUsernameAndPwd(user.getUsername(), user.getPassword());
        if(rSet == 0){
           try {
               resp.getWriter().write("<script>alert('操作失败');</script>");
           } catch (IOException e) {
               System.out.println(e);
           }
           return "login" ;
       }
       return  "logout";

    }

    @RequestMapping("/toRegister")
    public  String toRegister(User user, HttpServletResponse resp){
        user.setUserType(0);
        user.setUserAvails(0.0);
        System.out.println("toRegister测试："+user);
        Integer rSet = userService.addObject(user);
        if(rSet == 0){
            try {
                resp.getWriter().write("<script>alert('操作失败');</script>");
            } catch (IOException e) {
                System.out.println(e);
            }
            return "register" ;
        }
        return  "login";
    }
}
