package com.qa.skyrim.weapons.one_handed;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



public class OneHanded {
	
	private int id;
	private String name;
	
	public OneHanded() {
	}
	
	public OneHanded(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
	
//	String[] oneHanded ={"sword", "axe", "mace", "dagger", "fork"};
//	int randomNum = (int)(Math.random() * 5);
	}
