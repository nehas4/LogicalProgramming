package practice;

import java.util.Scanner;

public class GradeLoop 
{
	public static void main(String[] args)
	{
		double exam[] = new double[3];
		double finalExam;
		double total = 0;
		
		//exam category types in array
		String[] exam_category = {"programming", "Homework", "Labs", "Quizzes", "Readings", "Exam"};
		
		//array of category wise weight in the same order of category array values
		double[] category_Weight = {.15, .10, .05, .10, .10, .05};

		//Create scanner
		Scanner in = new Scanner(System.in);
		
		GradeLoop gradeLoopObj = new GradeLoop();
		
		//Create String
		String conti ="";
		do
		{ 
			double exam1Weight = .05;
			double finalWeight = .20;
			
			double input_grade = 0.0;
			double examSum = 0;
			
			//Asking user to input grades
			System.out.println("Enter grades: ");
			for(int i = 0; i<exam_category.length; i++)
			{
				int input_no = 0;
				int exam_no = 0;
				double gradeSum = 0;
				if(!exam_category[i].equalsIgnoreCase("Exam"))
				{
					System.out.println("Enter grades from "+exam_category[i]+" assignments: ");
				}
				else
				{
					System.out.println("Enter exam "+(exam_no+1)+": ");
				}
				
				while((input_grade = in.nextDouble()) >= 0)
				{
					if(!exam_category[i].equalsIgnoreCase("Exam"))
					{
						input_no++;
						gradeSum = gradeSum + input_grade;
					}
					else
					{
						double examWeight = input_grade * exam1Weight;
						examSum = examSum + examWeight;
						System.out.println("Exam "+(exam_no+1)+" weight: "+examWeight);
						continue;
					}
				}
				total = total + gradeLoopObj.printAssgmAvgWeight(gradeSum, category_Weight[i], exam_category[i], input_no);
			}

			System.out.println("Enter final exam: ");
			finalExam = in.nextDouble();
			finalExam = finalExam * finalWeight;
	          
			System.out.println("Final exam weight: "+finalExam);

			total = total + examSum + finalExam;
			System.out.println(" ");
			System.out.println("Grade for class: "+total);

			/*
			 * In this part of the program, a switch statement will be used to display the letter grade
			 */
	  
			//Asking user to input grade for the class from the result of the final grade
			System.out.print("Enter the grade you got for the class: ");
			int Grade = (int)in.nextDouble();
	     
			//Switch statement is created to display letter grade
			switch (Grade/10)
			{
				//Grade from 100 to 90
				case 10:
				case 9:
					System.out.println("Your grade is a A.");
					break;
				//Grade from 89 to 80
				case 8:
					System.out.println("Your grade is a B.");
					break;
				//Grade from 79 to 70       
				case 7:
					System.out.println("Your grade is a C.");
					break;
				//Grade from 69 to 60
				case 6:
					System.out.println("Your grade is a D.");
					break;
					//Grade less than 60   
				default:
					System.out.println("Your grade is a F.");
	         
				//While-loop to ask the user to continue the program or quit it          
			}
			while(!conti.equals("continue") && !conti.equals("quit"))
			{
				System.out.println("Enter 'continue' or 'quit'");
				conti = in.next();
			}
			
		}
		while(conti.equals("continue"));
		in.close();
	}
	
	double printAssgmAvgWeight(double gradeSum, double weight, String assignmentName, int input_no)
	{
		double calcValue = 0;

		calcValue = gradeSum/input_no;
		System.out.print("Average of "+assignmentName+" assignments: ");
		System.out.println(calcValue);

		calcValue = calcValue * weight;
		System.out.print("Weight of "+assignmentName+" assigments: ");
		System.out.println(calcValue);

		System.out.println(" ");
		return calcValue;
	}
}