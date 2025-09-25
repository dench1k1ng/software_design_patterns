package assignment_2.vehicleproducer;

import assignment_2.carfactory.Car;
import assignment_2.carfactory.SUV;
import assignment_2.carfactory.Sedan;
import assignment_2.truckfactory.PickupTruck;
import assignment_2.truckfactory.SemiTruck;
import assignment_2.truckfactory.Truck;

public class VehicleProducer {

    // Produce Car (Sedan, SUV)
    public Car createCar(String type, String color, String engineType) {
        if (type.equalsIgnoreCase("Sedan")) {
            return new Sedan(color, engineType);  // Create Sedan
        } else if (type.equalsIgnoreCase("SUV")) {
            return new SUV(color, engineType);  // Create SUV
        }
        throw new IllegalArgumentException("Unknown car type");
    }

    // Produce Truck (PickupTruck, SemiTruck)
    public Truck createTruck(String type, String loadCapacity) {
        if (type.equalsIgnoreCase("PickupTruck")) {
            return new PickupTruck(loadCapacity);  // Create PickupTruck
        } else if (type.equalsIgnoreCase("SemiTruck")) {
            return new SemiTruck(loadCapacity);  // Create SemiTruck
        }
        throw new IllegalArgumentException("Unknown truck type");
    }
}