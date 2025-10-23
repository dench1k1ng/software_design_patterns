package coffeeshop.core;

public class SimpleCoffee implements Coffee {
    private static final float BASE_COST = 4.0F;
    private static final String BASE_DESCRIPTION = "Simple Coffee";

    @Override
    public float getCost() {
        return BASE_COST;
    }

    @Override
    public String getDescription() {
        return BASE_DESCRIPTION;
    }
}