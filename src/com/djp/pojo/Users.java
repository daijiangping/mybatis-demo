package com.djp.pojo;

public class Users {
	private long id;
	private String name;
	private String address;
	private String tell;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", address=" + address
				+ ", tell=" + tell + "]";
	}

}
