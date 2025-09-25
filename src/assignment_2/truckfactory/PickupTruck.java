package assignment_2.truckfactory;

public class PickupTruck implements Truck {
    private final String loadCapacity;

    public PickupTruck(String loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void haul() {
        System.out.println("Hauling cargo with a Pickup Truck. Load capacity: " + loadCapacity);
    }

    @Override
    public String getLoadCapacity() {
        return loadCapacity;
    }
}