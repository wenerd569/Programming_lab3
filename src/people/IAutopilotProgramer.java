package people;


import exeption.ObjectNotFoundExeption;
import cars.*;
import roads.Way;

public interface IAutopilotProgramer {
    public void takeMap(IAutopilot target) throws ObjectNotFoundExeption;
    public void drawWay(Way way) throws ObjectNotFoundExeption;
    public void putMap(IAutopilot target) throws ObjectNotFoundExeption;

    public AutopilotCar makeCarAutopilot(Car car);
}
