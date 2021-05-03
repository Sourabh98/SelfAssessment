package com.telusko.demorest;

import java.util.ArrayList;
import java.util.List;

/*This is same as DAO this class is also to interact with DB but we are calling it repo as in case of REST it does makes more sense*/
public class AlienRepository {

	private List<Alien> alienList;

	public AlienRepository() {
		/*
		 * Here we will mock the data for the Alien so instead of fetching the data from
		 * the db we will prepare a list and will insert the Alien object in that list
		 * so whenever someone will create the object of the AlienRepository list with
		 * the alien object will be prepared then we can perform further operation like
		 * we would be doing with the DB on that list so if we will say persist the data
		 * to the db in that case we will add the object to the list if we will say
		 * getAllElements then in that case we will return all the elements in the list,
		 * if we will say fetch the element on the basis of id then we will iterate the
		 * list and will return the object whose id matches with the gievn id
		 */
		alienList = new ArrayList<Alien>();
		Alien a1 = new Alien();
		a1.setId(100);
		a1.setName("Sourabh");
		a1.setPoints(70);
		Alien a2 = new Alien();
		a2.setId(101);
		a2.setName("Gaurav");
		a2.setPoints(80);
		/* Adding both the objects to the list.. */
		alienList.add(a1);
		alienList.add(a2);
	}

	public List<Alien> getAllAliens() {
		return alienList;
	}
	
	public Alien getAlien(int id)
	{
		for(Alien a: alienList)
		{
			if(a.getId()==id)
			{
				return a;
			}
		}
		
		return null;
	}
	
	public void saveAlien(Alien a)
	{
		alienList.add(a);
	}

}
