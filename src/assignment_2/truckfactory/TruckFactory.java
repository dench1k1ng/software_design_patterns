package assignment_2.truckfactory;

import assignment_2.vehicleproducer.VehicleProducer;

public class TruckFactory {

    private final VehicleProducer producer;

    // Constructor to initialize the VehicleProducer
    public TruckFactory() {
        this.producer = new VehicleProducer();  // VehicleProducer handles the creation
    }

    public Truck createTruck(String type, String loadCapacity) {
        return producer.createTruck(type, loadCapacity);  // Delegate to VehicleProducer
    }
}