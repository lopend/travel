package com.baize.travel.DB;

import com.baize.travel.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @crete 2019/7/22
 */
public class DBCenter {
    public static List<User>  userList = new ArrayList<>();
    static {
        User user = new User();
        user.setUsername("ls@qq.com");
        user.setPassword("123");
        userList.add(user);
    }
}
