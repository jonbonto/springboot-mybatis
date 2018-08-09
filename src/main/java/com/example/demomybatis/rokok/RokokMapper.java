package com.example.demomybatis.rokok;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

@Mapper
interface RokokMapper {
	@Select("select * from ROKOK")
	List<Rokok> findAll();
	@Select("select * from ROKOK where id = #{id}")
	Rokok selectById(int id);
	@Insert("INSERT INTO ROKOK (nama,harga) values(#{nama},#{harga})")
	@SelectKey(statement="call identity()",keyProperty="id",before=false,resultType=Integer.class)
	void insert(Rokok rokok);
	@Update("Update ROKOK SET nama = #{nama}, harga = #{harga} where id = #{id}")
	void update(Rokok rokok);
	@Delete("DELETE FROM ROKOK WHERE id = #{id}")
	void delete(int id);
}
