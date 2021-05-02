package coreJava.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {
	
	public static void main(String[] args) {
		
		HashSet<String> hashSet=new HashSet<String>();
		TreeSet<String> treeSet=new TreeSet<String>();
		
		hashSet.add("first");
		hashSet.add("Second");
		hashSet.add("Third");
		hashSet.add("Fourth");
		hashSet.add("Fifth");
		
		treeSet.addAll(hashSet);
		treeSet.add("sixth");
		Iterator<String> hashSetIterator=hashSet.iterator();
		System.out.println("Iterating hashset using the Iterator..");
		while(hashSetIterator.hasNext())
		{
			System.out.println(hashSetIterator.next());
		}
		
		System.out.println("Iterting hashSet using for each loop..");
		for(String str:hashSet)
		{
			System.out.println(str);
		}
		
		System.out.println("Iterating treeSet using iterator..");
		Iterator<String> treeSetIterator=treeSet.iterator();
		System.out.println("Tree based collections maintains the sorting order on the basis of the sorting logic provided in the class whose object we are adding in the collection..");
		while(treeSetIterator.hasNext())
		{
			System.out.println(treeSetIterator.next());
		}
		System.out.println("Iterating treeSet using for each loop..");
		for(String str: treeSet)
		{
			System.out.println(str);
		}
		
		
	}

}
