package codiltity;

public class GuideWireProblem {
	
	
	public static void main(String[] args) {

		//int[] inputArr = { 114, 132, 119, 91, 84, 29, 61, 76, 38, 21, 9, 63, 65, 68, 81, 124, 118, 78, 44, 59, 80 };
		int[] inputArr= {6,1,4,6,3,2,7,4};
		int K=3;
		int L=2;
		System.out.println(solution(inputArr, K, L));

	}

	private static int solution(int[] A, int K, int L) {
		if(K==L)
			return -1;
		else
		{
		int maxAppleForAlice=0;
		 for (int i=0; i<K; i++) 
			 maxAppleForAlice += A[i]; 
		 int localSumForAlice=maxAppleForAlice;
		for(int i=K;i<A.length;i++)
		{
			localSumForAlice+=A[i]-A[i-K];
			maxAppleForAlice=Math.max(maxAppleForAlice,localSumForAlice);
		}
		int maxAppleForBob=0;
		 for (int i=0; i<L; i++) 
			 maxAppleForBob += A[i]; 
		 int localSumForBob=maxAppleForBob;
		for(int i=L;i<A.length;i++)
		{
			localSumForBob=localSumForBob-A[i-L]+A[i];
			maxAppleForBob=Math.max(maxAppleForBob,localSumForBob);
		}
		return maxAppleForAlice+maxAppleForBob;
		}
	}

}
