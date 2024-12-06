package roads;


import java.util.ArrayList;

import cars.Car;

public class ParkingSpace{
    ArrayList<Car> cars = new ArrayList<>();
    
    public void addCar(Car car){
        cars.add(car);
    }

    public Car searchLastCar(){
        return cars.get(cars.size()-1);
    }
}