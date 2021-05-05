package com.heng.dao;

import com.heng.pojo.User;
import com.heng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void test(){

        // 第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();


        // 方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserList();

        for (User user: userList) {
            System.out.println(user);
        }

        // 关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserLike("李");

        for(User user: userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(2);

        System.out.println(user);

        sqlSession.close();

    }

    @Test
    public void getUserId2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();

        map.put("userId", 3);

        User user = mapper.getUserById2(map);

        System.out.println(user);

        sqlSession.close();
    }


    // 增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(4, "赵六", "123444"));
        if (res>0) {
            System.out.println("插入成功！");
        }

        // 提价事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();

        map.put("userId", 5);
        map.put("userName", "Hello");
        map.put("password", "122222");

        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(1,"钱二", "654321"));

        if(res > 0) {
            System.out.println("修改成功！");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.deleteUser(4);

        if(res > 0){
            System.out.println("删除成功！");
        }

        sqlSession.commit();
        sqlSession.close();
    }

}
