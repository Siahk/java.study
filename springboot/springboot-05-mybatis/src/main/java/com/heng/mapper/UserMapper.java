package com.heng.mapper;

import com.heng.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// 表示了这是一个 mybatis 的 mapper 类
@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById();

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}