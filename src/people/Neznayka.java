package people;

import cars.IAutopilot;
import exeption.AutopilotExeption;
import other.Vector2;

public class Neznayka extends Human implements IAutopilotUser{    
    
    public Neznayka(Vector2 coord){
        super(coord);
    }

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
