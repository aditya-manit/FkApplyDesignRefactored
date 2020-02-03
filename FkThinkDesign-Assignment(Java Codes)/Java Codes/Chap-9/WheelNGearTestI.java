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


class Wheel{
    private float rim,tire;

    Wheel(float rim,float tire){
        this.rim=rim;
        this.tire=tire;
    }


    float diameter(){
        return this.rim + (this.tire * 2);
    }

}

class Gear{


    private  float chainRing,cog,tire,rim;

    Gear(Map<String ,Float> m1){
        this.chainRing =m1.get("chainRing");
        this.cog=m1.get("cog");
        this.rim=m1.get("rim");
        this.tire=m1.get("tire");
    }

    float gearInches(){
        return this.ratio()*(new Wheel(this.rim,this.tire).diameter());
    }


    float ratio(){
        return (this.chainRing / (float)this.cog);
    }
}

class WhellTest extends TestCase {
    @Test
    void testCalculatesDiameter()
    {
        Wheel wheel = new Wheel(26, (float)1.5);

        assertEquals(29, wheel.diameter(),0.01);}

}


class GearTest extends TestCase{
    @Test
    public void testCalculatesGearInches(){
        Map<String , Float> m1=new HashMap<>();
        m1.put("chainRing",(float)52);
        m1.put("cog",(float)11);
        m1.put("rim",(float)26);
        m1.put("tire",(float)1.5);
        Gear gear= new Gear(m1);
        assertEquals(137.1,gear.gearInches(),0.01);
    }
}

public class WheelNGearTestI{
    public static void main(String args[]){
        WhellTest w1=new WhellTest();
        GearTest g1=new GearTest();
        w1.testCalculatesDiameter();
        g1.testCalculatesGearInches();
    }
}
