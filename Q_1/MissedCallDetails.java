package Q_1;

import java.util.*;

class MissedCallDetails
{
    Calendar cal;
    Long telno;
    String name;
    MissedCallDetails(Calendar x,Long y,String z)
    {
        cal=x;
        telno=y;
        name=z;
    }
    void display()
    {
        System.out.println("Current time ="+cal.getTime());
        System.out.println("Telephone Number="+telno);
        System.out.println("Name is="+name);
    }
}