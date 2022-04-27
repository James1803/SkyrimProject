package com.qa.skyrim.weapons.two_handed;

public class TwoHanded {

	public static void main(String[] args) {
		
		String[] twoHanded ={"greatsword", "battleaxe", "warhammer"};
		int randomNum = (int)(Math.random() * 3);
		System.out.println(twoHanded[randomNum]);
	}
}
