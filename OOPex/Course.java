package OOPex;

public class Course {
	
	int NumStd ;
	String[] firstName;
	String[] lastName;
	int[] id;
	int[][] date;
	int[] grade;
	
	public Course (){}
	
	public Course (int NumStd)
	{
		firstName = new String[NumStd];
		lastName = new String[NumStd];
		id = new int [NumStd];
		date = new int[NumStd][3];
		grade = new int [NumStd];
		this.NumStd= NumStd;
	}
	
	public Course (int NumStd, String[] firsName, String[] lastName, int[] id, int[][] date, int[] grade)
	{
		firstName = new String[NumStd];
		lastName = new String[NumStd];
		id = new int [NumStd];
		date = new int[NumStd][3];
		grade = new int [NumStd];
		
		this.NumStd= NumStd;
		this.firstName = firsName;
		this.lastName = lastName;
		this.id = id;
		this.date = date;
		this.grade = grade;
	}
	
	public int getNumStd ()
	{
		return NumStd;
	}
	public String[] getfirstNameARR ()
	{
		return firstName;
	}
	
	public String[] getlastNameARR ()
	{
		return lastName;
	}
	
	public String getfirstName (int j)
	{
		return firstName[j];
	}
	
	public String getlastName (int j)
	{
		return lastName[j];
	}
	
	public int[] getid ()
	{
		return id;
	}
	
	public int[][] getdate ()
	{
		return date;
	}
	
	public int[] getgrade ()
	{
		return grade;
	}
	
	public void setNumStd  (int NumStd)
	{
	    this.NumStd = NumStd;
	}
	
	public void setfirstName (String firstName,int j)
	{
		this.firstName[j] = firstName;
	}
	
	public void setlastName (String lastName, int j)
	{
		this.lastName[j]= lastName;
	}
	
	public void setid (int id, int j)
	{
		this.id[j]= id;
	}
	
	public void setdete (int j,int date, int l)
	{
		this.date[j][l] = date;
	}
	
	public void setgrade (int grade, int j)
	{
		this.grade[j] = grade;
	}
}
