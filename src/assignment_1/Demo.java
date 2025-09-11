package assignment_1;

public class Demo {
    public static void main(String[] args) {
        Car customCar = new Car.Builder()
                .seats(4)
                .engine("Electric")
                .gps(false)
                .tripComputer(true)
                .build();
        System.out.println("Custom Car: " + customCar);

        CarDirector director = new CarDirector();
        Car sports = director.buildSportsCar();
        Car family = director.buildFamilyCar();

        System.out.println("Sports Car: " + sports);
        System.out.println("Family Car: " + family);
    }
}
