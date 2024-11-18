import cars.AutopilotCar;
import exeption.AutopilotExeption;
import exeption.ObjectNotFoundExeption;
import people.*;
import roads.Plases;
import roads.Way;
import table.MapSign;


public class Main {

    public static void main(){
        MapSign map = new MapSign(Plases.FLOWER_CITY, Plases.SUNNY_CITY);
        Way way = new Way(Plases.SUNNY_CITY, Plases.FLOWER_CITY);
        AutopilotCar car = new AutopilotCar(map, Plases.SUNNY_CITY);

        Human knopochka = new Knopochka(); 
        Human neznayka = new Neznayka();
        Human pestrenkiy = new Pestrenkiy();
        Human wizard = new Wizard();

        knopochka.walk(car);
        neznayka.walk(car);
        pestrenkiy.walk(car);
        wizard.walk(car);


        System.out.println("подойдя к " + car.toString());

        if (wizard instanceof IAutopilotProgramer){
            try {
                ((IAutopilotProgramer) wizard).drawWay(way, car);
                wizard.openCarDoor(car);

                neznayka.sitInCar(car);
                knopochka.sitInCar(car);
                pestrenkiy.sitInCar(car);

                wizard.closeCarDoor(car);
                wizard.waveHand();

                ((IAutopilotUser)neznayka).startAutopilot(car);

                neznayka.waveHand();
                knopochka.waveHand();
                pestrenkiy.waveHand();

                wizard.waveHand();
            } catch (ObjectNotFoundExeption e) {
                System.out.println(e.getMessage());
            } catch (AutopilotExeption e){
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("Волшебник не умеет чинить машину(");
            System.out.println("Поэтому ребята пошли пешком");
        }
    }
}