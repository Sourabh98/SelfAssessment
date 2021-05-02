package coreJava.collections;

public class BitMapProb {
	
	public static void main(String[] args) {
		
	}

	public Integer countRegions(int[][] bitmap)
	{
		int counter=0;
		for(int i=0;i<bitmap.length;i++)
		{
			for(int j=0;j<bitmap.length;j++)
			{
				//[0][1]
				if(bitmap[i][j]==1)
				{
					//[0][2],[1][1]
					if(bitmap[i-1][j]==1)
					{
						bitmap[i-1][j]=0;
						
					}
					if(bitmap[i][j+1]==1)
					{
						bitmap[i][j+1]=0;
					}
					if(bitmap[i+1][j]==1)
					{
						bitmap[i+1][j]=0;
					}
					if(bitmap[i-1][j-1]==1)
					{
						bitmap[i-1][j-1]=0;
					}

					

				}
			}
			
		}
		return null;
	}

}
