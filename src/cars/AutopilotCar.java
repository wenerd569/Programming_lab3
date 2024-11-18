package cars;

import cars.details.radiator.IMapHolder;
import cars.details.radiator.RadiatorWithMapSign;
import cars.details.seat.SoftSeat;
import exeption.*;
import people.Human;
import roads.Places;
import table.IMap;


public class AutopilotCar extends Car implements IAutopilot{
    protected RadiatorWithMapSign radiator;
    
    public AutopilotCar(IMap map, Places place){
        super(place);
        radiator = new RadiatorWithMapSign(map);
        seat = new SoftSeat();
    }

    @Override
    public void startAutopilot(Human actor) throws AutopilotExeption{
        System.out.printf("%1$s нажал кнопку на щитке приборов\n", actor.toString());
        try{
            var way = getMapHolder().getMap().getWay();
            if (way.startSity() != place){
                throw new AutopilotExeption("Вы не в том городе");
            }
            drive();
        } catch (ObjectNotFoundExeption e){
            throw new AutopilotExeption(e.getMessage());
        }
    }

    @Override
    public IMapHolder getMapHolder() {
        return radiator;
    }

    @Override
    public String toString(){
        return "крайняя машина";
    }
}
