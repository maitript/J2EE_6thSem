package Q_3;

import java.util.*;
public class STUDENT1
{
	String name,usn,address,category;
	int age;
	double sg1,sg2,sg3,sg4,sg5,sg6,sg7,sg8,cgpa;
	
	STUDENT1(String a,String b,String c,String d,int e,double s1,double s2,double s3, double s4,double s5,double s6,double s7,double s8)
	{ 
		name=a; usn=b; address=c; category=d; age=e;  
		sg1=s1; sg2=s2; sg3=s3; sg4=s4; sg5=s5; sg6=s6; sg7=s7; sg8=s8;
		
		
	}
	
	public String toString()
	{
		return name+"  "+usn+"  "+address+"  "+category+"   "+age+"    CGPA="+cgpa ;
		  
	}                                            
}
