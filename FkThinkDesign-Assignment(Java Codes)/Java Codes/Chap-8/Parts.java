package chapter8;

import java.util.ArrayList;


public class Parts {
    Part part;
    ArrayList<Part> a;
    public Parts(Part ...part)
    {
        a = new ArrayList<Part>();
        for(Part p:part)
            a.add(p);
    }
    public ArrayList<Part> spares()
    {
        ArrayList<Part> a1 = new ArrayList<Part>();
        for(Part p: a)
        {
            if(p!=null&&p.needs_spare)
                a1.add(p);
        }
        return a1;
    }
}