package cars;

import exeption.StateExeption;
import people.Human;

public interface ICar {
    public void go();
    public void sit(Human actor) throws StateExeption;
    public void openDoor(Human actor) throws StateExeption;
    public void closeDoor(Human actor) throws StateExeption;
}
