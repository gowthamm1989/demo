package com.sample;

public class Account {
	
	private String name;
	@Override
	public String toString() {
		return "Account [name=" + name + ", money=" + money + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	private long money;

	
}
