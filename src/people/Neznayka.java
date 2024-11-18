package people;

import cars.IAutopilot;
import exeption.AutopilotExeption;

public class Neznayka extends Human implements IAutopilotUser{    
    
    @Override
    public void waveHand() {
        System.out.printf("%1$s помахал рукой\n", toString());
    }

    @Override
    public void startAutopilot(IAutopilot target) throws AutopilotExeption{
        target.startAutopilot(this);
    }


    @Override
    public String toString(){
        return "Незнайка";
    }
}
