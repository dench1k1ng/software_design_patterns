package assignment_2;

import assignment_2.carfactory.Car;
import assignment_2.carfactory.CarFactory;
import assignment_2.carfactory.CarProducer;
import assignment_2.truckfactory.Truck;
import assignment_2.truckfactory.TruckFactory;
import assignment_2.truckfactory.TruckProducer;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        TruckFactory truckFactory = new TruckFactory();

        Car sedan = carFactory.createCar("Sedan", "Red", "V6");
        sedan.drive();

        Car suv = carFactory.createCar("SUV", "Black", "V8");
        suv.drive();

        Truck pickupTruck = truckFactory.createTruck("PickupTruck", "1500kg");
        pickupTruck.haul();

        Truck semiTruck = truckFactory.createTruck("SemiTruck", "5000kg");
        semiTruck.haul();
    }
}
