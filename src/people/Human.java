package people;


import java.util.Vector;

import cars.Car;
import cars.ICar;
import exeption.StateExeption;
import other.RealObject;
import other.Vector2;

public abstract class Human extends RealObject{

    public abstract void waveHand();

    public Human(Vector2 coord){
        super(coord);
    }

    public void walk(RealObject target){
        setCoord(target.getCoord());
        System.out.printf("%1$s подошёл к %2$s\n", toString(), target.toString());
    } 
    public void turnBack(){
        System.out.printf("%1$s обернулся назад\n", toString());
    }

    public void openCarDoor(ICar car) throws StateExeption{
        car.openDoor(this);
    }
    public void closeCarDoor(ICar car) throws StateExeption{
        car.closeDoor(this);
    }

    public void sitInCar(ICar car) throws StateExeption{
        car.sit(this);
    }
}
