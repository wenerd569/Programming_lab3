import java.util.ArrayList;

import cars.AutopilotCar;
import cars.Car;
import cars.IAutopilot;
import exeption.*;
import other.Vector2;
import people.*;
import roads.*;
import sign.*;


public class Main {

    public static void main(String[] args){
        Way way = new Way(Places.SUNNY_CITY, Places.FLOWER_CITY);
        var p2 = new Vector2(20, 20);

        ParkingSpace parkingSpace = geterateParkingSpace(Places.SUNNY_CITY);

        Human knopochka = new Knopochka(p2); 
        Human neznayka = new Neznayka(p2);
        Human pestrenkiy = new Pestrenkiy(p2);
        Wizard wizard = new Wizard(p2);

        Car car = parkingSpace.searchLastCar();



        knopochka.walk(car);
        neznayka.walk(car);
        pestrenkiy.walk(car);
        wizard.walk(car);


        System.out.println("подойдя к " + car.toString());
        
        if (wizard instanceof IAutopilotProgramer == false) {
            System.out.printf("%1$s не умеет чинить машину(\n", wizard.toString());
            walkToDestanationPoint();
            return;
        }

        AutopilotCar autopilotCar;
        if (!(car instanceof IAutopilot)){
            autopilotCar = wizard.makeCarAutopilot(car);
        } else{
            autopilotCar = (AutopilotCar)car;
        }

        try {
            wizard.takeMap(autopilotCar);
            wizard.drawWay(way);
            wizard.putMap(autopilotCar);
            
            wizard.openCarDoor(autopilotCar);
            
            neznayka.sitInCar(autopilotCar);
            knopochka.sitInCar(autopilotCar);
            pestrenkiy.sitInCar(autopilotCar);
            
            wizard.closeCarDoor(autopilotCar);
            
            wizard.waveHand();


            if (neznayka instanceof IAutopilotUser == false){
                wizardDriveCar(wizard, autopilotCar, way);
                return;
            }
            else{

                ((IAutopilotUser)neznayka).startAutopilot(autopilotCar);
                neznayka.turnBack();
                knopochka.turnBack();
                pestrenkiy.turnBack();
                neznayka.waveHand();
                knopochka.waveHand();
                pestrenkiy.waveHand();
                wizard.waveBeard();
            }
        }
        catch (ObjectNotFoundExeption e) {
            System.out.println("Возникла ошибка: " + e.getMessage());
            wizardDriveCar(wizard, autopilotCar, way);                    
        } 
        catch (AutopilotExeption e){
            System.out.println("Возникла ошибка: " + e.getMessage());
            wizardDriveCar(wizard, autopilotCar, way);
        } catch (StateExeption e){
            System.out.println("Ребята не смогли разобраться с устройством автомобиля");
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


    private static ParkingSpace geterateParkingSpace(Places place){
        ParkingSpace parkingSpace = new ParkingSpace();
        
        parkingSpace.addCar(new Car(place, new Vector2(0, 10)));
        parkingSpace.addCar(new Car(place, new Vector2(2, 10)));
        parkingSpace.addCar(new Car(place, new Vector2(4, 10)));
        parkingSpace.addCar(new Car(place, new Vector2(6, 10)));

        MapSign map = new MapSign(Places.FLOWER_CITY, Places.SUNNY_CITY);
        parkingSpace.addCar(new AutopilotCar(map, place, new Vector2(10, 10)));

        return parkingSpace;
    }
}