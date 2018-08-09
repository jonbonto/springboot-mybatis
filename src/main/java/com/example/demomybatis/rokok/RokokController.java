package com.example.demomybatis.rokok;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rokok")
class RokokController {
	
	@Autowired
	RokokServices rokokServices;
	
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
