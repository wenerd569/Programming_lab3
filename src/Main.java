import cars.AutopilotCar;
import exeption.AutopilotExeption;
import exeption.ObjectNotFoundExeption;
import people.*;
import roads.Places;
import roads.Way;
import table.MapSign;


public class Main {

    public static void main(String[] args){
        MapSign map = new MapSign(Places.FLOWER_CITY, Places.SUNNY_CITY);
        Way way = new Way(Places.SUNNY_CITY, Places.FLOWER_CITY);
        AutopilotCar car = new AutopilotCar(map, Places.SUNNY_CITY);

        Human knopochka = new Knopochka(); 
        Human neznayka = new Neznayka();
        Human pestrenkiy = new Pestrenkiy();
        Wizard wizard = new Wizard();

        knopochka.walk(car);
        neznayka.walk(car);
        pestrenkiy.walk(car);
        wizard.walk(car);


        System.out.println("подойдя к " + car.toString());

        if (wizard instanceof IAutopilotProgramer){
            try {
                ((IAutopilotProgramer)wizard).drawWay(way, car);
                wizard.openCarDoor(car);

                neznayka.sitInCar(car);
                knopochka.sitInCar(car);
                pestrenkiy.sitInCar(car);

                wizard.closeCarDoor(car);
                wizard.waveHand();

                ((IAutopilotUser)neznayka).startAutopilot(car);

                neznayka.turnBack();
                knopochka.turnBack();
                pestrenkiy.turnBack();

                neznayka.waveHand();
                knopochka.waveHand();
                pestrenkiy.waveHand();

                wizard.waveBeard();
            }
            catch (ObjectNotFoundExeption e) {
                System.out.println("Возникла ошибка: " + e.getMessage());
                wizardDriveCar(wizard, car, way);                    
            } 
            catch (AutopilotExeption e){
                System.out.println("Возникла ошибка: " + e.getMessage());
                wizardDriveCar(wizard, car, way);
            }
        }
        else{
            System.out.printf("%1$s не умеет чинить машину(\n", wizard.toString());
            walkToDestanationPoint();
        }
    }
    private static void wizardDriveCar(Wizard wizard, AutopilotCar car, Way way){
        if (wizard instanceof ICarDriver){
            System.out.printf("поэтому %1$s решил, что он поведёт сам\n", wizard.toString());
            ((ICarDriver)wizard).driveCar(car, way.endCity());
        } else{
            System.out.printf("%1$s не умеет водить машину\n", wizard.toString());
            walkToDestanationPoint();
        }
    }
    private static void walkToDestanationPoint(){
        System.out.println("Поэтому ребята пошли пешком");
    }
}