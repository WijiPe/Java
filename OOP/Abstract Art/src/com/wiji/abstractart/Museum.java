package com.wiji.abstractart;

import java.util.ArrayList;
import java.util.Random;

//inside of Museum.java
public class Museum {
	public static void main(String[] args) {
		Painting p1 = new Painting("a", "b", "c", "d");
		Painting p2 = new Painting("1", "2", "3", "4");
		Painting p3 = new Painting("a1", "b1", "c1", "d1");
//		p1.viewArt();
//		p2.viewArt();
//		p3.viewArt();
		
		Sculpture s1 = new Sculpture("as", "bs", "cs", "ds");
		Sculpture s2 = new Sculpture("aaas", "aabs", "aacs", "aads");
//		s1.viewArt();
//		s2.viewArt();
		
		ArrayList<Art> museum = new ArrayList<Art> ();
		museum.add(p1);
		museum.add(p2);
		museum.add(p3);
		museum.add(s1);
		museum.add(s2);
	
		        
		 Random rand = new Random();
		 for(int i = 0; i < museum.size(); i++){
		    int randomIndex = rand.nextInt(museum.size());
		    Art temp = museum.get(i);
		    museum.set(i,  museum.get(randomIndex));
		    museum.set(randomIndex, temp);
		 }
		
		for(Art a:museum) {
			a.viewArt();
		}
		
		
	}
}
