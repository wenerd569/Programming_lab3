package cars.details.seat;

import java.util.ArrayList;

import people.Human;

public class Seat {
    protected ArrayList<Human> passengers = new ArrayList<Human>();

    public void sit(Human human){
        passengers.add(human);
    }

    @Override
    public String toString(){
        return "сиденье";
    }
}
