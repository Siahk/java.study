package com.heng.controller;

import com.heng.dao.DepartmentDao;
import com.heng.dao.EmployeeDao;
import com.heng.pojo.Department;
import com.heng.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emps/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 查询所有部门的信息
        Collection<Department> departmentDaoController = departmentDao.getDepartmentMap();
        model.addAttribute("departments",departmentDaoController);
        return "emps/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        // 添加的操作
        System.out.println("set==>" + employee);
        employeeDao.setEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String updateEmp(@PathVariable("id")Integer id, Model model) {
        // 查询出数据
        Collection<Department> departmentDaoController = departmentDao.getDepartmentMap();
        model.addAttribute("departments",departmentDaoController);
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);
        return "emps/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeDao.setEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/deleteEmp{id}")
    public String deleteEmp(@PathVariable("id")Integer id) {
        employeeDao.deleteEmployee(id);
        return "redirect:/emps";
    }

}