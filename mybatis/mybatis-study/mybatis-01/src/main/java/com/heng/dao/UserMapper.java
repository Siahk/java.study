package com.heng.dao;

import com.heng.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();


    // Like
    List<User> getUserLike(String value);

    // 根据ID查询用户
    User getUserById(int id);

    User getUserById2(Map<String, Object> map);


    // 插入一个用户
    int addUser(User user);

    int addUser2(Map<String, Object> map);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);
}
