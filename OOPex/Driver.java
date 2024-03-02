package OOPex;
import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Number of classes: ");
		int NumClass = in.nextInt();
		Course[] student = new Course[NumClass];
		
		char firstCh=' ';
		String lastName = null;
		int[] grades = null;
		String [][] email = null;
		String[][] sortStr = null; 
		double[] Avg = new double[NumClass];
	    for (int i=0; i<NumClass; i++)
	    {
	    	System.out.println("Enter Number of students in class "+(i+1)+" :");
	    	student[i] = new Course(in.nextInt());
	    	grades = new int[student[i].getNumStd()];
	    	email = new String [NumClass][student[i].getNumStd()];
	    	sortStr = new String [NumClass][student[i].getNumStd()];
	    	
	    	for (int j=0; j<student[i].getNumStd(); j++)
	    	{
	    		student[i].setfirstName(in.next(), j);
	    		student[i].setlastName(in.next(), j);
	    		student[i].setid(in.nextInt(),j);
	    		for (int l=0; l<3; l++)
	    		{
	    			student[i].setdete(j,in.nextInt(),l);
	    		}
	    		student[i].setgrade(in.nextInt(), j);
	    	}
	    	for (int j=0;j<student[i].getNumStd(); j++)
	    	{
	    		firstCh = student[i].getfirstName(j).charAt(0);
	    		lastName = student[i].getlastName(j);
	    		email[i][j] = Email(firstCh, lastName);
	    	}
	    	grades = student[i].getgrade();
	    	Avg[i] = Average(grades);
	    	sortStr[i] = SortInstring(student[i].getfirstNameARR(),student[i].getlastNameARR(),student[i].getid(),student[i].getdate(),student[i].getgrade());
	    }
	    
	}
	
	
	public static String Email (char firstCh, String lastName)
	{
		int FCint = firstCh;
		char FCh =' ';
		if (FCint>=65 && FCint<=90)
		{
			FCint = FCint + 32 ;
		}
		FCh = (char)FCint;
		
		String lowerlastName = lastName.toLowerCase();
		String email = FCh+""+lowerlastName+"@ritaj.birzeit.edu";
		return email;
	}
	
	public static double Average (int[] grades)
	{
		int sum = 0;
		int n=0;
		for (int i=0; i<grades.length; i++)
		{
			sum += grades[i];
			n++;
		}
		return sum/n;
	}
	
	public static String[] SortInstring (String[] firstName, String[] lastName, int[] id, int[][] date, int[] grade)
	{
		String[] sorted= new String [firstName.length];
		String[] lowerlastName = new String [lastName.length];
		int count1 =0;
		int count2 =0;
		for (int i=0; i<lastName.length;i++)
		{
		    lowerlastName[i] = lastName[i].toLowerCase();
		    for (int j=97;j<=122;j++)
		    {
		    	count1=0;
		    	count2=0;
		    	for (int l=0;l<lowerlastName[i].length();l++)
		    	{
		    		for (int f=1;f<lowerlastName[i].length();f++ )
		    		{
		    		if (lowerlastName[i].charAt(l)==(char)j)
		    			count1++;
		    		if (lowerlastName[f].charAt(l)==(char)j)
		    			count2++;
		    		if (count1==count2)
		    			break;
		    		String Stemp ;
		    		int Itemp;
		    		int[][] Atemp = new int[3][date.length];
		    		if (count1<count2)
		    		{
		    			Stemp = firstName[i];
		    			firstName[i]=firstName[f];
		    			firstName[f]=Stemp;
		    			Stemp = null;
		    			
		    			Stemp = lastName[i];
		    			lastName[i]=lastName[f];
		    			lastName[f]=Stemp;
		    			Stemp =null;
		    			
		    			Itemp = id[i];
		    			id[i]=id[f];
		    			id[f]=Itemp;
		    			Itemp =0;
		    			
		    			Atemp[i] = date[i];
		    			date[i]=date[f];
		    			date[f]=Atemp[i];
		    			
		    			Itemp = grade[i];
		    			grade[i]=grade[f];
		    			grade[f]=Itemp;
		    			Itemp =0;
		    		}
		    	}
		    }
		    }
		}
		for (int i=0;i<sorted.length;i++)
		{
			sorted[i]= firstName[i]+" "+lastName[i]+"   "+id[i]+"   "+date[i][0]+"/"+date[i][1]+"/"+date[i][2]+"   "+grade[i];
		}
		
		return sorted;
	}
	
}