package com.heng.dao;

import com.heng.pojo.Department;
import com.heng.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ContextLoaderListener;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 员工数据访问对象
@Repository
public class EmployeeDao {

    //
    private static Map<Integer, Employee> employeeMap = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employeeMap = new HashMap<>();

        employeeMap.put(1001, new Employee(1001, "AA", "A123456@qq.com", 0, new Department(101, "教学部")));
        employeeMap.put(1002, new Employee(1002, "BB", "B123456@qq.com", 1, new Department(102, "市场部")));
        employeeMap.put(1003, new Employee(1003, "CC", "C123456@qq.com", 0, new Department(103, "教研部")));
        employeeMap.put(1004, new Employee(1004, "DD", "D123456@qq.com", 1, new Department(104, "运营部")));
        employeeMap.put(1005, new Employee(1005, "EE", "E123456@qq.com", 0, new Department(105, "后勤部")));
    }

    //
    private static Integer initId = 1006;

    public void setEmployee(Employee employee){
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employeeMap.values();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeMap.get(id);
    }

    public void deleteEmployee(Integer id) {
        employeeMap.remove(id);
    }
}
