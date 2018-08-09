package com.example.demomybatis.rokok;

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
