package com.baize.travel.service.impl;

import com.baize.travel.DB.DBCenter;
import com.baize.travel.domain.User;
import com.baize.travel.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @crete 2019/7/22
 */
@Service
public class UserServiceImpl implements UserService {
    private  List<User> list = DBCenter.userList;
    @Override
    public Integer checkUsernameAndPwd(String name ,String pwd) {
        for (User user:list) {
            if(user.getUsername().equals(name)&&user.getPassword().equals(pwd)){
                return 1 ;
            }
        }
        return 0;
    }

    @Override
    public Integer addObject(User user) {

        list.add(user);
        return 1;
    }


}
