 package practice;

public class AllStringRecur {

	int A[];
	public static void main(String[] args) {
		
		int n = 2;
		int k = 3;
		
		AllStringRecur obj = new AllStringRecur();
		obj.A=new int[n];
		obj.k_string(n, k);
	}
	
	void k_string(int n, int k)
	{
		if(n < 1)
		{
			for(int j : A)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		else
		{
			for(int i=0; i<k; i++)
			{
				A[n-1]=i;
				k_string(n-1, k);
			}
		}
	}
}
