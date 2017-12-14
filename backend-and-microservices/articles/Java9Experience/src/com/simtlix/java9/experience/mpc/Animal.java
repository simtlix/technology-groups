package com.simtlix.java9.experience.mpc;

public interface Animal {

	void eat();
	
	void sleep();
	
	default void makeSound() {
		printString("Default sound!");
	}
	
	private void printString(String value) {
		System.out.println(value);

	}
}
