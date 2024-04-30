package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    // Delete a data row
    @Delete("delete from emp where id = #{id}")
    public int delete(Integer id);

    // Insert a new data row
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " VALUES (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    // Update user information
    @Update("update emp set username = #{username}, " +
            "name = #{name}, " +
            "gender = #{gender}, " +
            "image = #{image}, " +
            "job = #{job}, " +
            "entrydate = #{entrydate}, " +
            "dept_id = #{deptId}, " +
            "update_time = #{updateTime} where id = #{id}")
    public int update(Emp emp);

    /*
    // Select a data row based on an id and convert underscore_case column to camelcase class attribute manually
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time createTime, update_time UpdateTime from emp where id = #{id}")
    public Emp getEmpById(Integer id);

    @Results({
            @Result(column="dept_id", property = "deptId"),
            @Result(column="create_time", property = "createTime"),
            @Result(column="update_time", property = "updateTime")
    })
    @Select("select * from emp where id  = #{id}")
    public Emp getEmpById(Integer id);
     */

    // Query a data row based on an ID and enable auto-convert underscore_case column to camelcase attribute
    @Select("select * from emp where id = #{id}")
    public Emp getEmpById(Integer id);

    // Query employees record by conditioning
//    @Select("select * from emp where name like concat('%', #{name}, '%') and gender = #{gender} and " +
//            "entrydate between #{begin} and #{end} order by update_time desc")
//    public List<Emp> list(String name, short gender, LocalDate begin, LocalDate end);

    public List<Emp> list(String name, short gender, LocalDate begin, LocalDate end);

}
