package com;

public class Animal {
	
	String breed;
	double height;
	int weight;
	
	static {
		System.out.println("We are in ANIMAL class now...");
	}
	public Animal(String breed, double height, int weight) {
		super();
		this.breed = breed;
		this.height = height;
		this.weight = weight;
	}
	
	public Animal(double height, int weight) {
		
		this.height = height;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Animal [breed=" + breed + ", height=" + height + ", weight=" + weight + "]";
	}
	
	

}
