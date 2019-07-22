package com.baize.travel.service;

import com.baize.travel.domain.User;

/**
 * @crete 2019/7/22
 */
public interface UserService {
    Integer checkUsernameAndPwd(String name, String pwd);

    Integer addObject(User user);
}
