package people;

import cars.IDrived;
import roads.Places;

public interface ICarDriver{
    public void driveCar(IDrived car, Places destination);
}