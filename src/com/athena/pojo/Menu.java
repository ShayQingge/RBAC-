package com.athena.pojo;

import java.util.List;

public class Menu {
	private int id;
	private String name;
	private int pid;
	
	
	private List<Menu> children;
	
	
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}
	
	
	

}

