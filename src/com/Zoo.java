package com;

public class Zoo {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("We are in main thread now...");
		
	}

static {
		
		Standalone s = new Standalone();

		Animal b = new Dog("any", 5.10, 300, "Brown");

		Animal a = new Animal("any", 5.10, 300);

		//System.out.println(a);
		System.out.println(b);
	}

	
}



