package com.dxc.pojo;

public class Admin {

	private int accno;
	private String name;
	private String password;
	
	public Admin() {
	}

	public Admin(int accno, String name, String password) {
		this.accno = accno;
		this.name = name;
		this.password = password;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
