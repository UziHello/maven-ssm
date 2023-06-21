package com.yjw.ssm.service;

import com.github.pagehelper.PageInfo;
import com.yjw.ssm.pojo.Employee;

import java.util.List;

/**
 * @author shkstart
 * @create 2023-06-0218:33
 */
public interface EmployeeService {
    List<Employee> getAllEmployee();
    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
