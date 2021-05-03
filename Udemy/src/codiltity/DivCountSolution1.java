package codiltity;

public class DivCountSolution1 {

	public static void main(String[] args) {

		System.out.println(solution(4, 17, 3));
	}

	/* Below solution will give linear time complexity in worst case.. */
	private static int solution(int A, int B, int K) {
		int firstMultiple = 0;
		int lastMultiple = 0;

		for (int i = A; i <= B; i++) {
			if (i % K == 0) {
				firstMultiple = i;
				break;
			}
		}
		for (int i = B; i >= A; i--) {
			if (i % K == 0) {
				lastMultiple = i;
				break;
			}
		}
		if(lastMultiple!=0 || firstMultiple!=0)
		return (lastMultiple / K - firstMultiple / K) + 1;
		return 0;
	}
}
