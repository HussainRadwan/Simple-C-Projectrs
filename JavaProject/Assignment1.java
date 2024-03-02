package JavaProject;

import java.util.Scanner;
public class Assignment1 {
	
	//this method calculate the average, maximum, and minimum of temperatures 
	public static double[] Summary (double a[][])
	{
		double sum=0;
		int n =0;
		double max = a[0][0];
		double min = a[0][0];
		double[] AvgMaMi = new double[3];
		for(int i=0; i<a.length; i++)
		{
			for (int j=0; j<a[i].length;j++)
			{
				sum += a[i][j];
				n++;
				if (a[i][j] > max)
					max = a[i][j];
				if (a[i][j] < min)
					min = a[i][j];
			}
		}
		AvgMaMi[0] = sum/n*1.0;
		AvgMaMi[1] = max;
		AvgMaMi[2] = min;
		
		return AvgMaMi;
	}
	
	/*  this method calculate a number of temperatures less than or equal to the average of
	temperatures, and the number of temperatures above the average  */
	public static int[] countbelowAboveAverage (double a[][], double Avg)
	{
		int belowAbove[] = new int [2];
		int below =0;
		int Above =0;
		for(int i=0; i<a.length; i++)
		{
			for (int j=0; j<a[i].length;j++)
			{
				if (a[i][j] <= Avg)
					below++;
				if (a[i][j] > Avg)
					Above++;
			}
		}
		belowAbove[0] = below;
		belowAbove[1] = Above;
		
		return belowAbove;
	}
	
	/* this method sort the temperatures (per day) in ascending order during all days
	   store it in a new 2D dimensional array */
	public static double[][] sortArray (double a[][])
	{
		double [][] Sort = new double [a.length][];
		for(int i=0; i<a.length; i++)
		{
			Sort[i] = new double[a[i].length];
			for (int j=0; j<a[i].length; j++)
			{
				Sort[i][j] = a[i][j];
			}
		}
		
		for (int i=0; i<Sort.length; i++)
		{
			for (int t=0; t<Sort[i].length; t++)
			{
				for (int j=t+1; j<Sort[i].length; j++)
				{
					double p=0.0;
					if (Sort[i][j]<Sort[i][t])
					{
						p = Sort[i][t];
						Sort[i][t] = Sort[i][j];
						Sort[i][j] = p;
					}
				}
			}
		}
		return Sort;
	}
	
	// this method to print the sorted array on screen
	public static void printArray (double Sort[][])
	{
		for (int i=0; i<Sort.length; i++)
		{
			System.out.print((Sort[i].length)+"  ");
			for (int j=0; j<Sort[i].length; j++)
			{
				System.out.print(Sort[i][j]+"  ");
			}
			System.out.println(".");
		}
	}
	
	/* this method will return yes he/she can leave or no, he/she can�t leave,
	   to check if he/she can leave the hospital. The patient can leave only if the average 
	   for the last two highest read temperatures in the last two days was around normal (35.5-36.5 C).*/
	public static void leaveHospital (double a[][])
	{
		double avg;
		double sum=0;
		int n=0;
		for (int i=(a.length -2); i<a.length; i++)
		{
			for (int j=(a[i].length -2); j<a[i].length; j++)
			{
				sum += a[i][j];
				n++;
			}
		}
		avg = sum/n;
		if (avg>=35.5 && avg<=36.5)
		{
			System.out.print("Your average is Stable and it's: "+(avg)+", You can leave");
		}else {
			System.out.print("Your average is not Stable and it's: "+(avg)+", You can't leave");
		}
	}
	

	public static void main(String... args) {
		
		System.out.println("Enter number of days that a patient has entered the hospital ");
		Scanner input = new Scanner (System.in);
		int days = input.nextInt(); //Read number of days that a patient has entered the hospital
		int times ;
		double arr [][] = new double [days][];
		double Avg;
		double Max;
		double Min;
		double[] AvgMaMi = new double [3];
		
		for (int i=0; i<days; i++) //for loop to storage the temperatures in an array and how many it took 
		{
			System.out.println("number of times that nurse read the temperature of the patient in Celsius in day "+(i+1));
			times = input.nextInt(); //Read number of times that nurse read the temperature of the patient in Celsius
			arr[i] = new double[times]; //To determine the area od array 
			for (int j=0; j<times; j++)
			{
				System.out.println("the temperature "+(j+1));
				arr[i][j] = input.nextDouble(); //Read the temperature that was read by the nurse and store each temperature in the array.
				if (arr[i][j] >45 || arr[i][j] <30)
				{
					/*this for to display an error message and keep looping till the program gets the right
		             .If the user enters a temperature below 30 C or above 45C, then .*/
					for (;;) 
					{
						System.out.println("Error pleas enter again ");
						arr[i][j] = input.nextDouble();
						if (arr[i][j] <=45 && arr[i][j] >=30)
						{
							break;
						}
					}
				}
			}
		}
		AvgMaMi = Summary(arr); // calling 
		Avg = AvgMaMi[0];
		Max = AvgMaMi[1];
		Min = AvgMaMi[2];
		System.out.println("The maximum temperature is: "+Max);
		System.out.println("The minimum tempreture is: "+Min);
		System.out.println("The Average is: "+ String.format("%.2f", Avg)); // this system for print avg with 2 digits  
		
		int belowAbove[] = new int [2];
		belowAbove = countbelowAboveAverage(arr,Avg); //calling 
		System.out.println("Total Number of reading Below or equal average is "+belowAbove[0]);
		System.out.println("Total Number of reading Above average is "+belowAbove[1]);
		
		double [][] SortedArr = new double[days][];
		SortedArr = sortArray(arr); //caling
		System.out.println("After Sort array");
		printArray(SortedArr); //calling;
		
		leaveHospital(arr); //calling
		
	}		
}
