package com.springboot.mybatis.controller;

import com.springboot.mybatis.entity.EmployeeEntity;
import com.springboot.mybatis.entity.MsgEntity;
import com.springboot.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeController 控制层
 */
@RestController
@CrossOrigin(origins = "/**", maxAge = 3600)
public class EmployeeController {
    //注入服务层对象
    @Autowired
    private EmployeeService employeeService;

    //添加员工
    @PostMapping("/employee")
    @CrossOrigin("*")
    public MsgEntity addEmployee(EmployeeEntity employeeEntity) {
        employeeService.addEmployee(employeeEntity);
        return MsgEntity.success();
    }

    //获取全部员工信息
    @GetMapping("/employee")
    @CrossOrigin("*")
    public MsgEntity getListEmployee() {
        List<EmployeeEntity> list = employeeService.getListEmployee();
        return MsgEntity.success().add("list", list);
    }

    //修改员工信息
    @PutMapping("/employee")
    @CrossOrigin("*")
    public MsgEntity updataEmployee(EmployeeEntity employeeEntity) {
        employeeService.updataEmployee(employeeEntity);
        return MsgEntity.success();
    }

    //删除员工信息
    @DeleteMapping("/employee")
    @CrossOrigin("*")
    public MsgEntity deleteEmployee(String empId) {
        if (empId == null) {
            return MsgEntity.fail();
        }
        //批量删除
        if (empId.contains("-")) {
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = empId.split("-");
            //组装id的集合
            for (String string : str_ids) {
                employeeService.deleteEmployee(Integer.parseInt(string));
            }
        } else {
            employeeService.deleteEmployee(Integer.parseInt(empId));
        }
        return MsgEntity.success();
    }

    //根据empId获取员工信息
    @GetMapping("/employee_id")
    @CrossOrigin("*")
    public MsgEntity getEmployeeByEmpId(Integer empId) {
        EmployeeEntity emp = employeeService.getEmployeeByEmpId(empId);
        return MsgEntity.success().add("emp", emp);
    }

}
