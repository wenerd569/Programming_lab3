package people;


import exeption.ObjectNotFoundExeption;
import cars.IAutopilot;
import roads.Way;

public interface IAutopilotProgramer {
    public void drawWay(Way way, IAutopilot car) throws ObjectNotFoundExeption;
}
