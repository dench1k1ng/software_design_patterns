package assignment_1;

public class Car {
    private final int seats;
    private final String engine;
    private final boolean gps;
    private final boolean tripComputer;

    private Car(Builder builder) {
        this.seats = builder.seats;
        this.engine = builder.engine;
        this.gps = builder.gps;
        this.tripComputer = builder.tripComputer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seats=" + seats +
                ", engine='" + engine + '\'' +
                ", gps=" + gps +
                ", tripComputer=" + tripComputer +
                '}';
    }

    public static class Builder {
        private int seats;
        private String engine;
        private boolean gps;
        private boolean tripComputer;

        public Builder seats(int seats) {
            this.seats = seats;
            return this;
        }

        public Builder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder gps(boolean gps) {
            this.gps = gps;
            return this;
        }

        public Builder tripComputer(boolean tripComputer) {
            this.tripComputer = tripComputer;
            return this;
        }

        public Car build() {
            if (engine == null || engine.isEmpty()) {
                throw new IllegalStateException("Engine is required");
            }
            return new Car(this);
        }
    }
}
