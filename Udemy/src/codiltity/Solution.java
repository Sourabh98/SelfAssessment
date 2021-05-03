package codiltity;

import java.util.HashSet;

class Solution {
	
    public int solution(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> set=new HashSet<Integer>();
        int arrayLength=A.length;
        int counter=0;
        for(int i: A)
        {
            if(i>0)
            {
                set.add(i);
            }
        }
        int i;
        for(i=1;i<=arrayLength+1;i++)
        {
            if(!set.contains(i))
            {
               break;
            }
        }
        return i;
    }
}

