package coreJava.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		System.out.println("Preparing map for countries and there respective capitals..");
		hashMap.put("India", "New Delhi");
		hashMap.put("Pakistan", "Islamabdad");
		hashMap.put("Ireland", "Dublin");
		hashMap.put("France", "Paris");
		hashMap.put("Netherland", "Amsterdam");

		System.out.println("Adding the whole hasmap collection to the the treemap..");
		treeMap.putAll(hashMap);
		Set<Entry<String, String>> set = hashMap.entrySet();
		System.out.println("Traversing the map using iterator...");
		Iterator<Entry<String, String>> mapIterator = set.iterator();
		while (mapIterator.hasNext()) {
			Entry<String, String> obj = mapIterator.next();
			System.out.println("Key is " + obj.getKey() + " Value is " + obj.getValue());
		}

		System.out.println("Iterating the hashmap using foreach loop..");
		for (Entry<String, String> entry : hashMap.entrySet()) {
			System.out.println("Key is :" + entry.getKey() + " Value is :" + entry.getValue());
		}

		System.out.println("Now if you will see above, you will find hashmap is not sorted..");
		System.out.println("Now we are going to traverse the tree map...you will see the sorted result as tree based collections are sorted..");
		Set<Entry<String, String>> treeSet = treeMap.entrySet();
		Iterator<Entry<String, String>> treeIterator = treeSet.iterator();
		while (treeIterator.hasNext()) {
			Map.Entry<String, String> entry = treeIterator.next();
			System.out.println("Key is: " + entry.getKey() + " Value is: " + entry.getValue());
		}
		System.out.println("Traversing TreeMap using for each loop..");
		for (Entry<String, String> entry : treeMap.entrySet()) {
			System.out.println("Key is: " + entry.getKey() + " Value is: " + entry.getValue());
		}
		System.out.println("Searching for a key in hashMap..");
		if(hashMap.containsKey("India"))
			System.out.println("found");
		else
			System.out.println("Not found..");
		System.out.println("Removing an entry from the hash map..");
		hashMap.remove("India");
		System.out.println("Traversing hash map again after removing the element..");
		System.out.println("Iterating the hashmap using foreach loop..");
		for (Entry<String, String> entry : hashMap.entrySet()) {
			System.out.println("Key is :" + entry.getKey() + " Value is :" + entry.getValue());
		}
	}
}
