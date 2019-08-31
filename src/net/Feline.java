package net;

import java.util.ArrayList;
import java.util.List;

public class Feline extends Animal{

	String color;
	List<String> ll = new ArrayList<>();
	
	public List<String> getlist(){
		
		super.breed = "Tiger";
		ll.add(super.getBreed());
		super.breed = "Zebra";
		ll.add(super.getBreed());
		super.breed = "Cow";
		ll.add(super.getBreed());

		return ll;
	}
}
