package chapter6;

public class BadBicyle {
    //Example of a bad code with multiple embedded types in Bicycle class
    class Bicycle {
        String style;
        char size;
        String tapeColor;
        String frontShock;
        String rearShock;

        Bicycle(String styleVar, char sizeVar, String ... var) {
            style = styleVar;
            size = sizeVar;
            if (var.length == 3) {
                tapeColor = var[0];
                frontShock = var[1];
                rearShock = var[2];
            }
            else if (var.length == 2) {
                tapeColor = var[0];
                frontShock = var[1];
                //rearShock = rearShockVar;
            }
            else if (var.length == 1) {
                tapeColor = var[0];
                //frontShock = frontShockVar;
                //rearShock = rearShockVar;
            }
        }

        void spares() {
            if (style.equals("road")) {
                System.out.println("chain : 11-Speed " + "Tire Size : 23 "+tapeColor);
            }
            else {
                System.out.println("chain : 11-Speed " + "Tire Size : 2.1 "+frontShock);
            }
        }
    }

//
//        public static void main(String[] args) {
//            Bicycle bicycle = new BadBicyle.Bicycle("mountain", 'S', "Manitou", "Fox");
//            bicycle.spares();
//            Bicycle bicycle1 = new BadBicyle.Bicycle("road", 'M', "Red");
//            bicycle1.spares();
//        }


}
