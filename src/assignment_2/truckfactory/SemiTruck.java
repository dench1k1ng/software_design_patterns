package assignment_2.truckfactory;

public class SemiTruck implements Truck {
    private final String loadCapacity;

    public SemiTruck(String loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void haul() {
        System.out.println("Hauling cargo with a Semi Truck. Load capacity: " + loadCapacity);
    }

    @Override
    public String getLoadCapacity() {
        return loadCapacity;
    }
}
