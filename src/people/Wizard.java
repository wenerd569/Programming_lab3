package people;

import cars.*;
import cars.details.radiator.IMapHolder;
import exeption.ObjectNotFoundExeption;
import roads.Plases;
import roads.Way;
import table.IMap;

public class Wizard extends Human implements IAutopilotProgramer, ICarDriver{

    @Override
    public void waveHand(){
        System.out.printf("%f помахал рукой на прощание", toString());
    }

    @Override
    public void drawWay(Way way, IAutopilot target) throws ObjectNotFoundExeption{
        IMapHolder mapHolder = target.getMapHolder();
        System.out.printf("%1$s сунул руку в щель имевшуюся позади %2$s", toString(), mapHolder.toString());
        try{
            IMap map = mapHolder.getMap();
            System.out.println("и достал от туда " + map.toString());
            
            if (map.searthPlace(way.endCity()) && map.searthPlace(way.startSity())){
                System.out.println("нашёл на ней " + way.endCity().toString());
                map.drawWay(way);
                System.out.printf("и нарисовал на ней путь от %1$s до %2$s", way.startSity().toString(), way.endCity().toString());
                mapHolder.setMap(map);
                System.out.printf("потом усановил %1$s обратно в %2$s", map.toString(), mapHolder.toString());
            }
            else{
                System.out.printf("но он не нашел на %1$s нужный путь поэтому, поэтому", map.toString());
                throw new ObjectNotFoundExeption();
            }
        } catch (ObjectNotFoundExeption e){
            System.out.println("Но из-за того что: " + e.getMessage());
            throw e;
        }
    }
    
    @Override
    public void driveCar(Car car, Plases destanation) {
        car.drive();
    }

    @Override
    public String toString(){
        return "Волшебник";
    }
}