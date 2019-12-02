package com.stage.SwanTest;

import java.util.ArrayList;

public class User {
	
	private String name ;
	private ArrayList<String> repo ;
	
	
	public User(String name) {
		super();
		this.name = name;
		this.repo = null;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getRepo() {
		return repo;
	}
	public void setRepo(ArrayList<String> repo) {
		this.repo = repo;
	}
	
	
	

}
