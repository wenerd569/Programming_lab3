package cars;

import people.Human;
import cars.details.radiator.Radiator;
import cars.details.seat.Seat;
import cars.details.door.Door;
import roads.Places;


public class Car {
    protected Radiator radiator = new Radiator();
    protected Seat seat = new Seat();
    protected Door door = new Door();
    protected Places place;

    public Car(Places place){
        this.place = place;
    }

    public void drive(){
        System.out.printf("%1$s тронулась\n", toString());
    }
    public void sit(Human actor){
        seat.sit(actor);
        System.out.printf("%1$s cел на %2$s\n", actor.toString(), seat.toString());
    }
    public void openDoor(Human actor){
        door.open();
        System.out.printf("%1$s открыл %2$s\n", actor.toString(), door.toString());
    };
    public void closeDoor(Human actor){
        door.close();
        System.out.printf("%1$s закрыл %2$s\n", actor.toString(), door.toString());
    }
}
