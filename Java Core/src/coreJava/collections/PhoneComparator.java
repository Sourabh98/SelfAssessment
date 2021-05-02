package coreJava.collections;

import java.util.Comparator;

public class PhoneComparator implements Comparator<Emp> {

		
		@Override
		public int compare(Emp e1, Emp e2)
		{
			return e1.getEmpJob().compareToIgnoreCase(e2.getEmpJob());
		}

	}
	


