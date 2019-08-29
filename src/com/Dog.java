package com;

public class Dog extends Animal{
	
	String color;
	static {
		System.out.println("We are in DOG class now...");
	}

	public Dog(String breed, double height, int weight, String color) {
		super(breed, height, weight);
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dog [color=" + color + ", breed=" + breed + ", height=" + height + ", weight=" + weight + "]";
	}

	
}
