package codiltity;

import java.util.Arrays;

public class DiscIntersectionProblemSolutionFinal {

	public static void main(String[] args) {

		System.out.println(solution(new int[]{1,5,2,1,4,0}));
	}

	private static int solution(int[] A) {
		int len = A.length;
		Disclog[] discHistory = new Disclog[len * 2];
		/*
		 * This loop will give us all the touples for all the discs which are provided
		 * in array A
		 */
		for (int i = 0, j = 0; i < A.length; i++) {
			/*
			 * Now for each disc there would be the starting and the ending position so we
			 * will have to store them in the array and that is why we are using another
			 * varaible and that is why we use twice the length. i-A[i]--> this will give
			 * you the starting position as i represents the centre and the value at that
			 * index represents the radius for that disc
			 */
			/*
			 * this would be the one touple with starting position, type casting into long
			 * as the radius of the disc might be in long
			 */
			discHistory[j++] = new Disclog(i - (long) A[i], 1);
			/*
			 * i+A[i] this will give you the ending position for every disc and we will make
			 * touple by adding -1 to it and just so you know each value of Array A will
			 * repre- sent a disc and we will have to create two event logs for each disc
			 * one for starting position and another with ending position
			 */
			discHistory[j++] = new Disclog(i + (long) A[i], -1);
		}
		/*
		 * Now we will sort the touples either on the basis of the vale of x or on the
		 * basis of the second value in the touple if the starting or ending position
		 * are same
		 */
		Arrays.sort(discHistory);
		/*This variable would contain our final result*/
		int intersections=0;
		/*this is our cumulative variable of our event log we will be modifying these variables as 
		 * we would be going through the event log*/
		int activeIntersection=0;
		/*Now we will start iterating for every single log which we have in our array*/
		for(Disclog log: discHistory)
		{
			activeIntersection+=log.startEnd;
			/*Now we need to update the intersections variable and we only update it if our log is indicating that
			 * there is the start of the disc and the start of the disc can get identified on the basis of the second
			 * value in the touple*/
			if(log.startEnd>0)
			{
				/*This problem asks us to return the intersection pairs and because it's a pair it will always have to
				 * be minus 1. Not sure what does it mean??*/
				intersections+=activeIntersection-1;
			}
			if(intersections>10000000)
				return -1;
		}
		return intersections;
	}

}

class Disclog implements Comparable<Disclog> {
	/*
	 * These two attributes we are using to make a touple a touple would be the
	 * combination of the starting or ending position of the disc and then on the b-
	 * asis of the starting or ending position of the we will set the other element
	 * as +1 or -1
	 */
	public long x;
	public int startEnd;

	public Disclog(Long x, int startEnd) {
		this.x = x;
		this.startEnd = startEnd;
	}

	/*
	 * We are implementing this method to define the sorting logic on the basis of
	 * the starting or ending position and if we encounter the same starting or
	 * ending posi- tion then we will sort in descending order on the basis of the
	 * second value in the touple
	 */
	@Override
	public int compareTo(Disclog log) {
		return this.x != log.x ? Long.compare(this.x, log.x) : Integer.compare(log.startEnd, this.startEnd);
	}

}
