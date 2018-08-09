package com.example.demomybatis.rokok;

import org.springframework.stereotype.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

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
