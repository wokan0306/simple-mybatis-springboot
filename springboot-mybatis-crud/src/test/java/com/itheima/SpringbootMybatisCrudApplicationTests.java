package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    EmpMapper empMapper;

    @Test
    public void testDelete() {
        empMapper.delete(20);
    }

    @Test
    public void testInsert() {
        Emp employee = new Emp();

        employee.setUsername("Tom2");
        employee.setName("Tommy2");
        employee.setGender((short) 1);
        employee.setImage("1.jpg");
        employee.setJob((short) 1);
        employee.setEntrydate(LocalDate.parse("2005-01-01"));
        employee.setDeptId(1);
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        empMapper.insert(employee);
    }

    @Test
    public void testUpdate() {
        Emp employee = new Emp();

        employee.setUsername("Tom3");
        employee.setName("Tommy3");
        employee.setGender((short) 2);
        employee.setImage("1.jpg");
        employee.setJob((short) 3);
        employee.setEntrydate(LocalDate.parse("2005-01-01"));
        employee.setDeptId(1);
        employee.setUpdateTime(LocalDateTime.now());
        employee.setId(21);

        empMapper.update(employee);
    }

    @Test
    public void testGetById() {
        Emp emp = empMapper.getEmpById(21);
        System.out.println(emp);
    }

    @Test
    public void testList() {
        List<Emp> empList = empMapper.list("张", (short)1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        System.out.println(empList);
    }
}
