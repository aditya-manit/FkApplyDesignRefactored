package chapter2;

public class Gear {


    int chairning;
    int cog;
    Wheel wheel;

    public Gear(int chairning, int cog, Wheel wheel) {
        this.chairning = chairning;
        this.cog = cog;
        this.wheel = wheel;
    }

    double ratio(){
        return 1.0 * getChairning()/getCog();
    }

    double gear_inches(){
        return ratio() * getWheel().diameter();
    }

    public void setChairning(int chairning) {
        this.chairning = chairning;
    }

    public void setCog(int cog) {
        this.cog = cog;
    }

    public int getChairning() {
        return chairning;
    }

    public int getCog() {
        return cog;
    }

    public Wheel getWheel() {
        return wheel;
    }
}
