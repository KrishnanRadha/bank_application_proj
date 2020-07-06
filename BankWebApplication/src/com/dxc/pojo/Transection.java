package com.dxc.pojo;

public class Transection {

	private int accno;
	private String tyOfTran;
	private double balance;
	public Transection() {
	}
	public Transection(int accno, String tyOfTran, double balance) {
		super();
		this.accno = accno;
		this.tyOfTran = tyOfTran;
		this.balance = balance;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getTyOfTran() {
		return tyOfTran;
	}
	public void setTyOfTran(String tyOfTran) {
		this.tyOfTran = tyOfTran;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
