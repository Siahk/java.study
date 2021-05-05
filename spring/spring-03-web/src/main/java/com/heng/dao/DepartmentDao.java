package com.heng.dao;

import com.heng.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 部门数据访问对象
@Repository
public class DepartmentDao {
    // 模拟数据库中的数据
    private static Map<Integer, Department> departmentMap = null;

    static {
        departmentMap = new HashMap<>(); // 创建一个部门表

        departmentMap.put(101, new Department(101, "教学部"));
        departmentMap.put(102, new Department(102, "市场部"));
        departmentMap.put(103, new Department(103, "教研部"));
        departmentMap.put(104, new Department(104, "运营部"));
        departmentMap.put(105, new Department(105, "后勤部"));
    }

    // 获得所有部门信息
    public Collection<Department> getDepartmentMap() {
        return departmentMap.values();
    }

    // 通过id得到部门
    public Department getDepartmentById(Integer id) {
        return departmentMap.get(id);
    }


}
