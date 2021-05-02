package coreJava.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EmpHashMap {

	public static void main(String[] args) {

		System.out.println("Creating hash map for Employees...");
		Map<Integer, Emp> empMap = new HashMap<Integer, Emp>();
		empMap.put(1, new Emp("A", "B", 10000));
		empMap.put(2, new Emp("C", "D", 10000));
		empMap.put(3, new Emp("E", "F", 10000));
		empMap.put(4, new Emp("G", "H", 10000));
		empMap.put(5, new Emp("I", "J", 10000));
		empMap.put(6, new Emp("K", "L", 10000));

		System.out.println("Iterating hashMap using Iterator...........");
		Set<Map.Entry<Integer, Emp>> iteratorSet = empMap.entrySet();
		Iterator<Map.Entry<Integer, Emp>> iterator = iteratorSet.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Emp> entry = iterator.next();
			System.out.println("Key " + entry.getKey() + " Value " + entry.getValue().display());
		}
		System.out.println("Iterating using for each loop....");
		for (Map.Entry<Integer, Emp> entrySet : empMap.entrySet()) {
			System.out.println("Key " + entrySet.getKey() + " Value " + entrySet.getValue().display());
		}

		System.out.println(
				"Searching an employee with the properties Emp Name: G, Emp Job: H, Salary: 10000, if found then remove it");
		if (empMap.containsValue(new Emp("G", "H", 10000))) {
			System.out.println("Found.. removing the employee...");
			Iterator<Map.Entry<Integer, Emp>> hashMapIterator2 = iteratorSet.iterator();
			while (hashMapIterator2.hasNext()) {
				Map.Entry<Integer, Emp> entry = hashMapIterator2.next();
				if (entry.getValue().equals(new Emp("G", "H", 10000))) {
					System.out.println("Removing the employee....");
					empMap.remove(entry.getKey());
				}
			}

			System.out.println("Iterating the employee map after attempting to remove the element using iterator..");
			Set<Map.Entry<Integer, Emp>> entrySet = empMap.entrySet();
			Iterator<Map.Entry<Integer, Emp>> empMapIterator = entrySet.iterator();
			while (empMapIterator.hasNext()) {
				Map.Entry<Integer, Emp> entry = empMapIterator.next();
				System.out.println("Key " + entry.getKey() + " Value " + entry.getValue().display());
			}

		} else
			System.out.println("Not found...");

		System.out.println("Creating Tree Map for storing the Employee Objects...");
		Map<Integer, Emp> treeMap = new TreeMap<Integer, Emp>();
		treeMap.put(1, new Emp("M", "N", 10000));
		treeMap.put(2, new Emp("O", "P", 10000));
		treeMap.put(3, new Emp("Q", "R", 10000));
		treeMap.put(4, new Emp("S", "T", 10000));
		treeMap.put(5, new Emp("U", "V", 10000));

		System.out.println("Iterating the tree map using for each...");
		for (Map.Entry<Integer, Emp> entry : treeMap.entrySet()) {
			System.out.println("Key " + entry.getKey() + " Value " + entry.getValue().display());
		}

		System.out.println(
				"Searching an employee with the properties Emp Name: S, Emp Job: T, Salary: 10000, if found then remove it");
		if (treeMap.containsValue(new Emp("S", "T", 10000))) {
			System.out.println("Found....Removing the employee...");
			Set<Map.Entry<Integer, Emp>> treemapEntrySet = treeMap.entrySet();
			Iterator<Map.Entry<Integer, Emp>> treeMapIterator = treemapEntrySet.iterator();
			while (treeMapIterator.hasNext()) {
				Map.Entry<Integer, Emp> entry = treeMapIterator.next();
				if (entry.getValue().equals(new Emp("S", "T", 10000))) {
					System.out.println("Removing the employee....");
					treeMap.remove(entry.getKey());
				}

			}

			System.out.println(
					"Iterating the tree map again after attempting to remove the element from the tree map.....");
			Iterator<Map.Entry<Integer, Emp>> treeMapIetrator2 = treemapEntrySet.iterator();
			while (treeMapIetrator2.hasNext()) {
				Map.Entry<Integer, Emp> entry = treeMapIetrator2.next();
				System.out.println("Key " + entry.getKey() + " Value " + entry.getValue().display());
			}

		} else
			System.out.println("Not found....");
	}

}
