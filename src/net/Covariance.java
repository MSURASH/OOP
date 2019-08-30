package net;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Covariance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Animal> f = new ArrayList<>();
		Feline a = new Feline();
		List<String> fff = a.getlist();
		int len = fff.size();
		Feline[] ff = new Feline[len];

		//System.out.println(len);
		f(fff);
		
	}
	
	public static <T> void f(List<T> a) {
		Iterator<T> aa = a.iterator();
        while (aa.hasNext()) {
        	System.out.println(aa.next());
        }

	}

}
