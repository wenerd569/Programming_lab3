package people;

import cars.*;
import cars.details.radiator.IMapHolder;
import exeption.ObjectNotFoundExeption;
import roads.Places;
import roads.Way;
import table.IMap;

public class Wizard extends Human implements IAutopilotProgramer, ICarDriver{

    @Override
    public void waveHand(){
        System.out.printf("%1$s помахал рукой на прощание\n", toString());
    }
    public void waveBeard(){
        System.out.printf("Длинная борода %1$s развевалась по ветру, и от этого Пестренькому казалось, что %1$s машет им бородой\n", toString());
    }


    @Override
    public void drawWay(Way way, IAutopilot target) throws ObjectNotFoundExeption{
        IMapHolder mapHolder = target.getMapHolder();
        System.out.printf("%1$s сунул руку в щель имевшуюся позади %2$s\n", toString(), mapHolder.toString());
        IMap map = mapHolder.getMap();
        System.out.println("и достал от туда " + map.toString());
        
        if (map.searchPlace(way.endCity()) && map.searchPlace(way.startSity())){
            System.out.println("отыскав на ней " + way.endCity().toString());
            map.drawWay(way);
            System.out.printf("он начертил на ней карандашом путь по дорогам, которые вели от %1$s до %2$s\n", way.startSity().toString(), way.endCity().toString());
            mapHolder.setMap(map);
            System.out.printf("снув %1$s обратно в %2$s\n", map.toString(), mapHolder.toString());
        }
        else{
            System.out.printf("но он не нашел на %1$s нужный путь поэтому, поэтому\n", map.toString());
            throw new ObjectNotFoundExeption();
        }
    }
    
    @Override
    public void driveCar(Car car, Places destination) {
        System.out.println("cел за руль и завёлся");
        car.drive();
    }

    @Override
    public String toString(){
        return "Волшебник";
    }
}