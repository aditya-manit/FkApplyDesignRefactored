package chapter6;

public class InheritenceDemo {

    //Inheritance

    class Bicycle {
        char size;
        String chain;
        String tireSize;

        public Bicycle() {
        }

        Bicycle(char sizeVar, String ... var) {
            size = sizeVar;
            if (var.length == 2) {
                chain = var[0];
                tireSize = var[1];
            }
            else if (var.length == 1) {
                defaultChain();
                tireSize = var[0];
            }
        }

        void spares(){}

        void defaultChain() {
            chain = "11-speed";
        }
    }

    class MountainBike extends Bicycle {
        String frontShock;
        String rearShock;

        MountainBike(String frontShockVar, String rearShockVar) {
            frontShock = frontShockVar;
            rearShock = rearShockVar;
        }

        void spares() {
            super.spares();
        }
    }


}
