package people;

import cars.IAutopilot;
import exeption.AutopilotExeption;

public class Neznayka extends Human implements IAutopilotUser{    
    
    @Override
    public void waveHand() {
        System.out.println(toString() + "помахал рукой");
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
