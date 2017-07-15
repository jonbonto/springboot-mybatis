package com.example.demomybatis;

import java.util.Collection;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMybatisApplication.class, args);
	}
}

@RestController
class xxxController {
	
	@Autowired
	RokokServices rokokServices;
	
	@GetMapping("/")
	public String hello(){
		return "hello";
	}
	
	@GetMapping("/rokoks")
	public Collection<Rokok> allRokok(){
		return rokokServices.findAll();
	}
	
	@GetMapping("/rokok/{id}")
	public Rokok getRokokById(@PathVariable int id){
		return rokokServices.getById(id);
	}
	
	@GetMapping("/insertRokok/{nama}/{harga}")
	public String insert(@PathVariable String nama, @PathVariable int harga){
		return rokokServices.insert(nama,harga);
	}
	
	@GetMapping("/updateRokok/{id}/{nama}/{harga}")
	public String update(@PathVariable int id, @PathVariable String nama, @PathVariable int harga){
		return rokokServices.update(id, nama,harga);
	}
	@GetMapping("/deleteRokok/{id}")
	public String delete(@PathVariable int id){
		return rokokServices.delete(id);
	}
}

@Service
class RokokServices{
	
	@Autowired
	RokokMapper rokokMapper;
	
	public Collection<Rokok> findAll(){
		return rokokMapper.findAll();
	}
	
	public String delete(int id) {
		rokokMapper.delete(id);
		return "delete successfully";
	}

	public String update(int id, String nama, int harga) {
		rokokMapper.update(new Rokok(id,nama,harga));
		return "update successfully";
	}

	public Rokok getById(int id){
		return rokokMapper.selectById(id);
	}
	public String insert(String nama, int harga){
		rokokMapper.insert(new Rokok(nama,harga));
		return "insert successfully";
	}
}

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

class Rokok {
	
	private int id;
	private String nama;
	private int harga;
	
	
	public Rokok( int id, String nama, int harga) {
		this.nama = nama;
		this.id = id;
		this.harga = harga;
	}
	
	public Rokok( String nama, int harga) {
		this.nama = nama;
		this.harga = harga;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
}
