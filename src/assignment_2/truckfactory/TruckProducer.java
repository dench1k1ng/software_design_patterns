package assignment_2.truckfactory;

public class TruckProducer {

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