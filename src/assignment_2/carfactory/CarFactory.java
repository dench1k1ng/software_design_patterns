package assignment_2.carfactory;

import assignment_2.vehicleproducer.VehicleProducer;

public class CarFactory {

    private final VehicleProducer producer;

    // Constructor to initialize the VehicleProducer
    public CarFactory() {
        this.producer = new VehicleProducer();  // VehicleProducer handles the creation
    }

    public Car createCar(String type, String color, String engineType) {
        return producer.createCar(type, color, engineType);  // Delegate to VehicleProducer
    }
}