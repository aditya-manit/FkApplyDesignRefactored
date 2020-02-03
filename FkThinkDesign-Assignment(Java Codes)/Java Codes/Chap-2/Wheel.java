package chapter2;

public class Wheel {
    double rim;
    double tire;


    public Wheel(double rim, double tire) {
        this.rim = rim;
        this.tire = tire;
    }

    double diameter() {
        return getRim() + getTire() * 2;
    }

    double circumference() {
        return diameter() * Math.PI;
    }

    public void setRim(double rim) {
        this.rim = rim;
    }

    public void setTire(double tire) {
        this.tire = tire;
    }

    public double getRim() {
        return rim;
    }

    public double getTire() {
        return tire;
    }
}
