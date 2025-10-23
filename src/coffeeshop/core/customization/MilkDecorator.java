package coffeeshop.core.customization;

import coffeeshop.core.Coffee;

public class MilkDecorator extends CoffeeDecorator {
    private static final float MILK_COST = 0.75F;
    private static final String MILK_DESCRIPTION = ", with Milk";

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }


    @Override
    public float getCost() {
        return super.getCost() + MILK_COST;
    }


    @Override
    public String getDescription() {
        return super.getDescription() + MILK_DESCRIPTION;
    }
}
