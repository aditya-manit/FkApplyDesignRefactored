package chapter8;

public class ChapterDemo {

    public static void main(String[] args) {
        Part chain = new Part("chain","10-speed",true);
        Part  road_tire  = new Part("tire_size",  "23",true);
        Part tape = new Part("tape_color", "red",true);
        Part mountain_tire = new Part("tire_size", "2.1",true);
        Part rear_shock =new Part("rear_shock", "Fox",true);
        Part front_shock = new Part( "front_shock", "Manitou", false);
        Parts road_bike_part = new Parts(chain,road_tire,tape);
        Bicycle road_bike = new Bicycle('L',road_bike_part);
        Bicycle mountain_bike = new Bicycle( 'L' ,   new Parts(chain, mountain_tire,
                front_shock, rear_shock));
        System.out.println(road_bike.size);
        road_bike.spares();
        System.out.println(mountain_bike.size);
        mountain_bike.spares();

    }
}
