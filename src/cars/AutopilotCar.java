package cars;

import exeption.*;
import other.Vector2;
import people.Human;
import roads.Places;
import roads.Way;
import sign.IMap;


public class AutopilotCar extends Car implements IAutopilot{
    protected class RadiatorWithMapSign extends Radiator implements IMapHolder{
        private IMap map;
        
        public RadiatorWithMapSign(IMap map){
            this.map = map;
        }
        public IMap takeMap() throws ObjectNotFoundExeption {
            if (map == null)
                throw new ObjectNotFoundExeption();
            var temp = map;
            map = null;
            return temp;
        }
        public Way readWay() throws ObjectNotFoundExeption {
            if (map == null)
                throw new ObjectNotFoundExeption();
            return map.getWay();
        }
        @Override
        public void setMap(IMap map) {
            this.map = map;
        }
    }    
    


    protected RadiatorWithMapSign radiator;

    public AutopilotCar(IMap map, Places place, Vector2 coord){
        super(place, coord);
        radiator = new RadiatorWithMapSign(map);
    }

    @Override
    public void startAutopilot(Human actor) throws AutopilotExeption{
        System.out.printf("%1$s нажал кнопку на щитке приборов\n", actor.toString());
        try{
            var way = getMapHolder().readWay();
            if (way.startSity() != place){
                throw new AutopilotExeption("Вы не в том городе");
            }
            go();
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
        return "машина";
    }
}
