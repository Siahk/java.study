package com.heng.service;

import com.heng.mapper.UserMapper;
import com.heng.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userMapper.queryUserByName(userName);
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new org.springframework.security.core.userdetails.User(user.getName(), new BCryptPasswordEncoder().encode(user.getPwd()),auths);
    }
}