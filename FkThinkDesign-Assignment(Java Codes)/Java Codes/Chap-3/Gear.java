package chapter3;

public class Gear {


    int chairning;
    int cog;
    CircularObject circularObject;

    public Gear(int chairning, int cog, Wheel circular) {
        this.chairning = chairning;
        this.cog = cog;
        this.circularObject = circular;
    }

    double ratio(){
        return 1.0 * getChairning()/getCog();
    }

    double gear_inches(){
        return ratio() * getCircularObject().diameter();
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

    public CircularObject getCircularObject() {
        return circularObject;
    }
}
