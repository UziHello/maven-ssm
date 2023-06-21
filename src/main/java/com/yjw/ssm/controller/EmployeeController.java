package com.yjw.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.yjw.ssm.pojo.Employee;
import com.yjw.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author shkstart
 * @create 2023-06-0218:22
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        List<Employee> list=employeeService.getAllEmployee();
        model.addAttribute("list",list);
        return "employee_list";
    }
    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable Integer pageNum,Model model){
        //获取员工的分页信息
        PageInfo<Employee> page=employeeService.getEmployeePage(pageNum);
        //降分业数据共享到请求域中
        model.addAttribute("page",page);
        return "employee_list";
    }
}
