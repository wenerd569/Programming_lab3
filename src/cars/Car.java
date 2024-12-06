package cars;

import people.Human;
import exeption.StateExeption;
import other.RealObject;
import other.Vector2;

import java.util.ArrayList;

import roads.Places;

public class Car extends RealObject implements ICar, IDrived{
    private class Door{
        enum DoorState{
            OPEN,
            CLOSE,
        }
        protected DoorState state;
        public void open(){
            state = DoorState.OPEN;
        }
        public void close(){
            state = DoorState.CLOSE;
        }
        public boolean isOpen(){
            return (state == DoorState.OPEN);
        }
        @Override
        public String toString(){
            return "дверь";
        }
    }

    protected class Radiator {
        @Override
        public String toString(){
            return "радиатор";
        }
    }

    private class Seat{
        private Human passenger;
        public void sit(Human human) throws StateExeption{
            if (passenger == null){
                passenger = human;
            }
            else{
                throw new StateExeption();
            }
        }
        public boolean isFree(){
            return (passenger == null);
        }
        @Override
        public String toString(){
            return "мягкое сиденье";
        }
    }
    
    protected int seatCount = 4;
    protected int seatTake = 4;
    protected ArrayList<Car.Seat> seats = new ArrayList<Car.Seat>(seatCount);
    protected Radiator radiator = new Radiator();
    protected Door door = new Door();
    protected Places place;

    public Places getPlace(){
        return place;
    }

    public Car(Places place, Vector2 coord){
        super(coord);
        this.place = place;
    }

    @Override
    public void drive(Human actor, Places destanation) {
        System.out.printf("%1$s нажал на газ\n");
        go();
    }
    public void go(){
        System.out.printf("%1$s тронулась\n", toString());
    }
    public void sit(Human actor) throws StateExeption{
        if (seatTake < seatCount){
            seats.get(seatTake).sit(actor);
            System.out.printf("%1$s cел на %2$s\n", actor.toString(), seats.get(seatTake).toString());
            seatTake += 1;
        }
    }
    public void openDoor(Human actor){
        door.open();
        System.out.printf("%1$s открыл %2$s\n", actor.toString(), door.toString());
    };
    public void closeDoor(Human actor){
        door.close();
        System.out.printf("%1$s закрыл %2$s\n", actor.toString(), door.toString());
    }

    @Override
    public String toString(){
        return "самая обычная машина";
    }

}
