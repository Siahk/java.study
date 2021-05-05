package com.heng.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 */
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class User {
    private String name;
    private Integer age;

    private Pet pet;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
