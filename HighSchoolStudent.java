/*
You must extend Student to complete this class.
As seen on the back of the assignment document, HighSchoolStudent requires an 
additional private double variable, a (NEW and EXCITING) public static int variable, a constructor, two accessors, a mutator, and toString
*/

public class HighSchoolStudent extends Student
{
    private double daysMissed; 
    public static int totalHSStudents = 0;


    public HighSchoolStudent(String studentName, double missing)
    {
        super(studentName);
        daysMissed = missing; 
        totalHSStudents += 1; 
    }

    public String getName()
    {
        return super.toString();
    }
    
    public double getDaysMissed()
    {
        return daysMissed;
    }

    public void addAbsence(double amount)
    {
        daysMissed += amount; 
    }
    
    public String toString()
    {
        return super.toString() + " " + daysMissed; 
    }
}