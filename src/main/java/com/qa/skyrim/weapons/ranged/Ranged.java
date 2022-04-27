package com.qa.skyrim.weapons.ranged;

public class Ranged {

	public static void main(String[] args) {
		
		String[] ranged ={"bow", "cross bow", "spear"};
		int randomNum = (int)(Math.random() * 3);
		System.out.println(ranged[randomNum]);
	}
}
