package com.simtlix.java9.experience.mpc;

public class Dog implements Animal {

	@Override
	public void eat() {
		System.out.println("Eat as a dog!");
	}

	@Override
	public void sleep() {
		System.out.println("Sleep as a dog!");
	}

	@Override
	public void makeSound() {
		System.out.println("Guau!");
	}
	
}
