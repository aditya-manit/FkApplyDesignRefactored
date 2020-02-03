package com.company;

import java.util.*;
import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;



class Wheel2{
    private float rim,tire;

    Wheel2(float rim,float tire){
        this.rim=rim;
        this.tire=tire;
    }


    float diameter(){
        return this.rim + (this.tire * 2);
    }

}

class Gear2{


    private  float chainRing,cog;
    private Wheel2 w1;

    Gear2(Map<String ,Float> m1,Wheel2 tmp){
        this.chainRing =(float)m1.get("chainRing");
        this.cog=(float)m1.get("cog");
       this.w1=tmp;
    }

    float gearInches(){
        return this.ratio()*w1.diameter();
    }


    float ratio(){
        return (this.chainRing / (float)this.cog);
    }
}

class WhellTest2 extends TestCase {
    @Test
    void testCalculatesDiameter()
    {
        Wheel2 wheel = new Wheel2(26, (float)1.5);

        assertEquals(29, wheel.diameter(),0.01);}

}


class GearTest2 extends TestCase{
    @Test
    public void testCalculatesGearInches(){
        Map<String , Float> m1=new HashMap<>();
        m1.put("chainRing",(float)52);
        m1.put("cog",(float)11);

        Gear2 gear= new Gear2(m1,new Wheel2((float)26,(float)1.5));
        assertEquals(137.1,gear.gearInches(),0.01);

    }
}

public class WheelNGearTestII{
    public static void main(String args[]){
        WhellTest2 w1=new WhellTest2();
        GearTest2 g1=new GearTest2();
        w1.testCalculatesDiameter();
        g1.testCalculatesGearInches();
    }
}
