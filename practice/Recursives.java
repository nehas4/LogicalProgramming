package practice;

public class Recursives 
{
	static int boysLeft = 2;
	
	public static void main(String[] args) 
	{
		crossRiver(2);
	}
	
	 public static void crossRiver ( int n )
	 {
		 if(n != 0)
		 {
				 show(n);
				 n=n-1;
				 crossRiver(n);
		 }
	 }
	 
	 public static void show(int n)
	 {
		 StringBuffer sb = new StringBuffer("");
		 if(n != 0)
		 {
			 sb.append(n +" soldiers");
		 }
		 if(boysLeft == 1)
		 {
			 sb.append(", "+1 +" boys --->");
		 }

		 if(boysLeft < 2)
		 {
			 sb.append("1 soldier");
		 }
		 else if(boysLeft == 2)
		 {
			 sb.append(", 2 boys");
			 boysLeft = boysLeft - 1;
		 }
		 
		 System.out.println(sb);
	 }

}
