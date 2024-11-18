package people;

import cars.IAutopilot;
import exeption.AutopilotExeption;

public interface IAutopilotUser {
    public void startAutopilot(IAutopilot target) throws AutopilotExeption;
}
