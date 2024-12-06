package people;

import cars.*;
import exeption.ObjectNotFoundExeption;
import other.Vector2;
import roads.Places;
import roads.Way;
import sign.IMap;
import sign.MapSign;

public class Wizard extends Human implements IAutopilotProgramer, ICarDriver{

    private IMap map;


    public Wizard(Vector2 coord){
        super(coord);
    }

    @Override
    public void waveHand(){
        System.out.printf("%1$s помахал рукой на прощание\n", toString());
    }
    public void waveBeard(){
        System.out.printf("Длинная борода %1$s развевалась по ветру, и от этого Пестренькому казалось, что %1$s машет им бородой\n", toString());
    }
    
    @Override
    public AutopilotCar makeCarAutopilot(Car car) {
        System.out.println(toString() + " увидел, что это была самая обычная машина");
        MapSign map = new MapSign(Places.values());
        AutopilotCar autopilotCar = new AutopilotCar(map, car.getPlace(), car.getCoord());
        System.out.println("Поэтому взмахом волшебной палочки он превратил её в автопилотируемую");

        return autopilotCar;
    }
    @Override
    public void takeMap(IAutopilot target) throws ObjectNotFoundExeption {
        IMapHolder mapHolder = target.getMapHolder();
        System.out.printf("%1$s сунул руку в щель имевшуюся позади %2$s\n", toString(), mapHolder.toString());
        map = mapHolder.takeMap();
        System.out.println("и достал от туда " + map.toString());
    }
    @Override
    public void drawWay(Way way) throws ObjectNotFoundExeption {
        if (map.searchPlace(way.endCity()) && map.searchPlace(way.startSity())){
            System.out.println("отыскав на ней " + way.endCity().toString());
            map.drawWay(way);
            System.out.printf("он начертил на ней карандашом путь по дорогам, которые вели от %1$s до %2$s\n", way.startSity().toString(), way.endCity().toString());
        }
        else{
            System.out.printf("но он не нашел на %1$s нужный путь поэтому, поэтому\n", map.toString());
            throw new ObjectNotFoundExeption();
        }
    }
    @Override
    public void putMap(IAutopilot target) throws ObjectNotFoundExeption {
        IMapHolder mapHolder = target.getMapHolder();
        mapHolder.setMap(map);
        System.out.printf("снув %1$s обратно в %2$s\n", map.toString(), mapHolder.toString());
    }



    @Override
    public void driveCar(IDrived car, Places destination) {
        car.drive(this, destination);
    }
    
    @Override
    public String toString(){
        return "Волшебник";
    }

}