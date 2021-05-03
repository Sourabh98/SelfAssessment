package codiltity;

import java.util.Stack;

public class FishProblemSolutionFinal {
	
	public static void main(String[] args) {
		int[] fishWeight= {4,3,2,1,5};
		int[] fishDirection= {0,1,0,0,0};
		int[] fishWeight2= {4,8,2,6,7};
		int[] fishDirection2= {0,1,1,0,0};
		//Expected O/P is 2
		System.out.println(solution(fishWeight,fishDirection));
		//Expected output is 2
		System.out.println(solution(fishWeight2,fishDirection2));
	}
	
	private static int solution(int[] A, int[] B)
	{
		/*1 represents fish is going towards right, 0 represents fish is going towards left */
		int survivors=0;
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<A.length;i++)
		{
			int weight=A[i];
			//if this would be true means fishes are going in opposite direction
			if(B[i]==1)
			{
				/*We are only pushing the weights of the fishes to the stack only when the fish is going towards right
				 * then we will compare the fish direction and if we will encounter the fish which is going to left
				 * then we will compare the weights of that fish and the fishes which we have in stack and if the weight
				 * of the fish in the stack is less then we will pop out the fish from the stack.*/
				stack.push(A[i]);
			}
			else
			{
				/*So here if the fish is going to the left we will compare whatever we have on the stack 
				 * so we will create a variable to represent the fish weight which is going right or downstream
				 * so if the stack is empty which means till now we didn't encounter any fish which is going downstream
				 * or towards right and hence there won't be any value in the stack
				 * So if the stack is empty we are assigning the value -1 to the weight else we will assign whatever
				 * weight we have in the stack.*/
				int weightDown=stack.isEmpty()?-1:stack.pop();
				/*Now we need to keep on consuming from stack till the stack is not empty and weight of the fish swimming
				 * towards right/downstream is smaller then the weight of the fish going upstream/left as in this case
				 * the fish which is going towards left will eat  and then we need to compare the
				 * weight to the fish which is going upstream or towards the left.*/
				while(weightDown!=-1 && weightDown<weight)
				{
					weightDown=stack.isEmpty()?-1:stack.pop();
					/*We exit this loop for one of two reasons either the stack is empty which means when weightdown=-1 or when
					 * the weight of the fish swimming downstream is more then the weight of the fish swimming up stream as in 
					 * this case the fish going downstream will eat the fish going upstream.*/
				}
					if(weightDown==-1)
						/*This survivor will represent the fishes which are going up stream so when we will get the weight==-1
						 * that means stack is empty and none of the fishes weight which were going downstream wqas more then
						 * the weight of the fish which is going upstream.*/
						survivors++;
					else
						stack.push(weightDown);
				}
			}
			
		/*survivor variable will represent the number of fishes which were going to left and the stack size will 
		 * give us the number of fishes survived which were going to right..*/
		return survivors+stack.size();
	}

}
