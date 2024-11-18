package people;


import cars.Car;

public abstract class Human{

    public abstract void waveHand();

    public void walk(Object target){
        System.out.printf("%1$s подошёл к %2$s", toString(), target.toString());
    } 

    public void openCarDoor(Car car){
        car.openDoor(this);
    }
    public void closeCarDoor(Car car){
        car.closeDoor(this);
    }

    public void sitInCar(Car car){
        car.sit(this);
    }
}
