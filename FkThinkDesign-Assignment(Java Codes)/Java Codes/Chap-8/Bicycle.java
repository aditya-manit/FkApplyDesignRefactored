package chapter8;

import java.util.ArrayList;

class Bicycle {
    char  size;
    Parts parts;

    public Bicycle(char size, Parts parts)
    {
        this.parts=parts;
        this.size=size;

    }
    public void spares()
    {
        ArrayList<Part> a = parts.spares();
        for(Part p:a)
        {
            System.out.println(p.name+" "+p.description);
        }

    }

}
