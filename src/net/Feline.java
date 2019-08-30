package net;

import java.util.ArrayList;
import java.util.List;

public class Feline extends Animal{

	String color;
	List<String> ll = new ArrayList<>();
	
	public List<String> getlist(){
		
		
		ll.add("tiger");
		ll.add("zebra");
		ll.add("bull");
		ll.add("bull");
		ll.add("bull");

		return ll;
	}
}
