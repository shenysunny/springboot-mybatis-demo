package com.springboot.mybatis.service;

import com.springboot.mybatis.entity.EmployeeEntity;
import com.springboot.mybatis.mapper.EmployeeEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * EmployeeService 服务层
 */
@Service
public class EmployeeService {
    //注入接口对象
    @Autowired
    private EmployeeEntityMapper employeeEntityMapper;

    //添加员工
    public void addEmployee(EmployeeEntity employeeEntity) {
        employeeEntityMapper.insert(employeeEntity);
    }

    //获取全部员工信息
    public List<EmployeeEntity> getListEmployee() {
        return employeeEntityMapper.selectByExample(null);
    }

    //根据empId获取员工信息
    public EmployeeEntity getEmployeeByEmpId(Integer empId) {
        return employeeEntityMapper.selectByPrimaryKey(empId);
    }

    //修改员工信息
    public void updataEmployee(EmployeeEntity employeeEntity) {
        employeeEntityMapper.updateByPrimaryKeySelective(employeeEntity);
    }

    //删除员工信息
    public void deleteEmployee(Integer empId) {
        employeeEntityMapper.deleteByPrimaryKey(empId);
    }
}
