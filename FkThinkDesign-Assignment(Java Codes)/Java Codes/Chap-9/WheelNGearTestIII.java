package com.company;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.runner.RunWith;

import junit.framework.TestCase;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

class Wheel3{
    private float rim,tire;

    Wheel3(float rim,float tire){
        this.rim=rim;
        this.tire=tire;
    }


    float diameter(){
        return this.rim + (this.tire * 2);
    }

}


interface Observer{
float changed(float a,float b);}

class Gear3 {


    private float chainRing, cog;
    private Wheel3 w1;
    private Observer observer;

    Gear3(Map<String, Float> m1, Wheel3 tmp, Observer ob) {
        this.chainRing = (float) m1.get("chainRing");
        this.cog = (float) m1.get("cog");
        this.w1 = tmp;
        this.observer = ob;
    }

    float gearInches() {
        return this.ratio() * w1.diameter();
    }


    float ratio() {
        return (this.chainRing / (float) this.cog);
    }

    float setCog(float new_cog) {
        this.cog = new_cog;
       return this.changed();
    }

    void set_chainring(float new_chainring) {
        this.chainRing = new_chainring;
        this.changed();
    }

    float changed() {
    float b;
        b = observer.changed(chainRing, cog);
        return b;
    }

}

@RunWith(MockitoJUnitRunner.class)
    class GearTest3 {
    @InjectMocks
        Gear3 g1;
        @Mock
        Observer tmp;
        public void setUp(){
            Map<String , Float> m1=new HashMap<>();
            m1.put("chainRing",(float)10.0);
            m1.put("cog",(float)20.0);

            Gear3 gear= new Gear3(m1,new Wheel3((float)10.0,(float)20.0),tmp);
            when(tmp.changed((float)10.0,(float)20.0)).thenReturn((float)30.00);

            //test the add functionality
            assertEquals( (float)30.0, g1.setCog((float)20.0),0.01 );
        }


    }


public class WheelNGearTestIII {

        public  static  void Main(String args[]){
        GearTest3 t1=new GearTest3();
        t1.setUp();
        }
}
