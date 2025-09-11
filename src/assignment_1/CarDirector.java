package assignment_1;

public class CarDirector {
    public Car buildSportsCar() {
        return new Car.Builder()
                .seats(2)
                .engine("V8 Turbo")
                .gps(true)
                .tripComputer(true)
                .build();
    }

    public Car buildFamilyCar() {
        return new Car.Builder()
                .seats(5)
                .engine("Hybrid")
                .gps(true)
                .tripComputer(false)
                .build();
    }
}
