package cars;

import cars.details.radiator.IMapHolder;
import people.Human;
import exeption.AutopilotExeption;


public interface IAutopilot {    
    public void startAutopilot(Human actor) throws AutopilotExeption;
    public IMapHolder getMapHolder();
}