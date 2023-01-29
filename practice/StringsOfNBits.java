package practice;

public class StringsOfNBits {

	public static void main(String[] args) {
		int n = 4;
		int binary[] = new int[n];
		binaryString(binary, 4);
	}
	
	static void binaryString(int binary[], int n)
	{
		if(n < 1)
		{
			for(int i : binary)
			{
				System.out.print(i);
			}
			System.out.println();
		}
		else
		{
			
			binary[n-1] = 0;
			binaryString(binary, n-1);
			
			binary[n-1] = 1;
			binaryString(binary, n-1);
		}
	}
}
