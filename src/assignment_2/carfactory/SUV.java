package assignment_2.carfactory;

public class SUV implements Car {
    private final String color;
    private final String engineType;

    public SUV(String color, String engineType) {
        this.color = color;
        this.engineType = engineType;
    }

    @Override
    public void drive() {
        System.out.println("Driving a " + color + " SUV with " + engineType + " engine.");
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getEngineType() {
        return engineType;
    }
}