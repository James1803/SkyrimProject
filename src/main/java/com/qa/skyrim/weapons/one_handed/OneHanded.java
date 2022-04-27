package com.qa.skyrim.weapons.one_handed;

public class OneHanded {
	
	public static void main(String[] args) {
		
		String[] oneHanded ={"sword", "axe", "mace", "dagger", "fork"};
		int randomNum = (int)(Math.random() * 5);
		System.out.println(oneHanded[randomNum]);
	}
}
