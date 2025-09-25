package assignment_2.carfactory;

public class CarProducer {

    // Produce Car (Sedan, SUV)
    public Car createCar(String type, String color, String engineType) {
        if (type.equalsIgnoreCase("Sedan")) {
            return new Sedan(color, engineType);  // Create Sedan
        } else if (type.equalsIgnoreCase("SUV")) {
            return new SUV(color, engineType);  // Create SUV
        }
        throw new IllegalArgumentException("Unknown car type");
    }
}