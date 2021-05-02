package coreJava.collections;

import java.util.*;

public class EmpTreeSet {

	public static void main(String[] args) {
		TreeSet<Emp> empTreeSet = new TreeSet<Emp>();
		System.out.println("Adding elements to the EmpTreeSet and implemented the compareTo method in Emp so the objects will be added on the basis of the logic provided in this method............");
		empTreeSet.add(new Emp("Sourabh", "B", 20000));
		empTreeSet.add(new Emp("Gaurav", "Y", 30000));
		empTreeSet.add(new Emp("Vinay", "D", 40000));
		empTreeSet.add(new Emp("Deepu", "H", 50000));
		empTreeSet.add(new Emp("Kakul", "M", 60000));
		empTreeSet.add(new Emp("Ajju", "P", 70000));

		System.out.println("Iterating treeset using Iterator...");
		Iterator<Emp> empTreeSetIterator = empTreeSet.iterator();
		while (empTreeSetIterator.hasNext()) {
			System.out.println(empTreeSetIterator.next().display());
		}
		
		TreeSet<Emp> empJobTreeSet = new TreeSet<Emp>(new JobComparator());
		System.out.println("Adding elements to the empJobTreeSet............");
		empJobTreeSet.add(new Emp("A", "B", 20000));
		empJobTreeSet.add(new Emp("X", "Y", 30000));
		empJobTreeSet.add(new Emp("C", "D", 40000));
		empJobTreeSet.add(new Emp("G", "H", 50000));
		empJobTreeSet.add(new Emp("K", "M", 60000));
		empJobTreeSet.add(new Emp("O", "P", 70000));

		System.out.println("Iterating treeset using empJobTreeSetIterator...");
		Iterator<Emp> empJobTreeSetIterator = empJobTreeSet.iterator();
		while (empJobTreeSetIterator.hasNext()) {
			System.out.println(empJobTreeSetIterator.next().display());
		}

		/* Here we are using Anonymous inner class for */
		TreeSet<Emp> empSalaryTreeSet = new TreeSet<Emp>(new Comparator<Emp>() {
			@Override
			public int compare(Emp e1, Emp e2) {
				return e1.getSalary() - e2.getSalary();
			}
		});
		System.out.println("Adding elements to the empSalaryTreeSet............");
		empSalaryTreeSet.addAll(empJobTreeSet);
		
		System.out.println("Iterating empSalaryTreeSet using Iterator...");
		Iterator<Emp> empSalaryTreeSetIterator = empSalaryTreeSet.iterator();
		while (empSalaryTreeSetIterator.hasNext()) {
			System.out.println(empSalaryTreeSetIterator.next().display());
		}

		/*
		 * You can use the lambda expression like below in the second statement i
		 * removed the return statement as JRE will automatically map it to the
		 * functional interface and will get to know what we wanted to return
		 */
		TreeSet<Emp> empSalaryTreeSet2 = new TreeSet<Emp>((e1, e2) -> {
			return e1.getSalary() - e2.getSalary();
		});
		
		empSalaryTreeSet2.add(new Emp("A", "B", 1111));
		empSalaryTreeSet2.add(new Emp("X", "Y", 666666));
		empSalaryTreeSet2.add(new Emp("C", "D", 222));
		empSalaryTreeSet2.add(new Emp("G", "H", 44));
		empSalaryTreeSet2.add(new Emp("K", "M", 7777777));
		empSalaryTreeSet2.add(new Emp("O", "P", 3333));
		
		System.out.println("Iterating empSalaryTreeSet using for each...");
		for(Emp e: empSalaryTreeSet2)
		{
			System.out.println(e.display());
		}
		TreeSet<Emp> empSalaryTreeSet3 = new TreeSet<Emp>((e1, e2) -> e1.getSalary() - e2.getSalary());
		
		empSalaryTreeSet3.addAll(empJobTreeSet);
		
		System.out.println("Iterating empSalaryTreeSet3 using iterator....");
		System.out.println("Emp Name  Emp Job  Salary");
		Iterator<Emp> empSalaryTreeSet3Iterator=empSalaryTreeSet3.iterator();
		while(empSalaryTreeSet3Iterator.hasNext())
		{
			System.out.println(empSalaryTreeSet3Iterator.next().display());
		}
		
		System.out.println("Searching for A, B, 1111 in empSalaryTreeSet2..." );
		if(empSalaryTreeSet2.contains(new Emp("A", "B", 1111)))
		{
			System.out.println("A, B, 1111 found removing it....");
			empSalaryTreeSet2.remove(new Emp("A", "B", 1111));
		}
		else
			System.out.println("not found...");
		
		System.out.println("Iterating the empSalaryTreeSet2 again aftet removing the A, B, 1111");
		Iterator<Emp> empSalaryTreeSet2Iterator=empSalaryTreeSet2.iterator();
		while(empSalaryTreeSet2Iterator.hasNext())
		{
			System.out.println(empSalaryTreeSet2Iterator.next().display());
		}
	}
}
