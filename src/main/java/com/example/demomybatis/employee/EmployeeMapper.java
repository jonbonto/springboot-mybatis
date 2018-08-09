package com.example.demomybatis.employee;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

@Mapper
interface EmployeeMapper {
	@Select("select * from EMPLOYEE")
	List<Employee> findAll();
	@Select("select * from EMPLOYEE where id = #{id}")
	Employee selectById(int id);
	@Insert("INSERT INTO EMPLOYEE (first_name,last_name,age,job,address) values(#{firstName},#{lastName},#{age},#{job},#{address})")
	@SelectKey(statement="call identity()",keyProperty="id",before=false,resultType=Integer.class)
	void insert(Employee employee);
	@Update("Update EMPLOYEE SET first_name = #{firstName}, last_name = #{lastName}, age = #{age}, job = #{job}, address = #{address} where id = #{id}")
	void update(Employee employee);
	@Delete("DELETE FROM EMPLOYEE WHERE id = #{id}")
	void delete(int id);
}
