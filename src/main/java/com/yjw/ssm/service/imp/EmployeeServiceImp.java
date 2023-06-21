package com.yjw.ssm.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjw.ssm.mapper.EmployeeMapper;
import com.yjw.ssm.pojo.Employee;
import com.yjw.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shkstart
 * @create 2023-06-0218:33
 */
@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployee = employeeMapper.getAllEmployee();
        return allEmployee;
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        PageHelper.startPage(pageNum,4);
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> page = new PageInfo<>(list,5);/*5表示导航分页*/
        return page;
    }
}
