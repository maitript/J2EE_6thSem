package Q_1;

import java.util.*;

public class DataBaseCallers
{
    public static HashMap<Long,String> contacts=new HashMap<Long,String>();
    static void createEntry()
    {
        contacts.put(new Long("9900726035"),"Ronaldo");
        contacts.put(new Long("9741278570"),"Messi");
        contacts.put(new Long("7255554444"),"Deepika");
        contacts.put(new Long("9700001111"),"Kaka");
    }
    static void display()
    {
        System.out.println("***************DataBaseCallers*****************");
        System.out.println(contacts);
        
    }
}





