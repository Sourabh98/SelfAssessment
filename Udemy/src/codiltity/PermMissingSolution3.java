package codiltity;

public class PermMissingSolution3 {
	
	public static void main(String[] args) {

		int[] arr = { 2, 3, 1, 5 };
		System.out.println("Missing element is " + missingElement(arr));
	}
	
	public static int missingElement(int[] A) {
		
		int missingValue=0;
		int[] lookupArr=new int[A.length+2];
		for(int i: A)
		{
			lookupArr[i]=i;
		}
		for(int i=1;i<lookupArr.length;i++)
		{
			if(lookupArr[i]==0)
			{
				missingValue=i;
				break;
			}
		}
		
		return missingValue;
	}

}
