package com.springboot.mybatis.mapper;

import com.springboot.mybatis.entity.EmployeeEntity;
import com.springboot.mybatis.entity.EmployeeEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeEntityMapper {
    int countByExample(EmployeeEntityExample example);

    int deleteByExample(EmployeeEntityExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(EmployeeEntity record);

    int insertSelective(EmployeeEntity record);

    List<EmployeeEntity> selectByExample(EmployeeEntityExample example);

    EmployeeEntity selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("record") EmployeeEntity record, @Param("example") EmployeeEntityExample example);

    int updateByExample(@Param("record") EmployeeEntity record, @Param("example") EmployeeEntityExample example);

    int updateByPrimaryKeySelective(EmployeeEntity record);

    int updateByPrimaryKey(EmployeeEntity record);
}