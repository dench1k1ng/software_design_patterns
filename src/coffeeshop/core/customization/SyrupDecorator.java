package coffeeshop.core.customization;

import coffeeshop.core.Coffee;

public class SyrupDecorator extends CoffeeDecorator {
    private static final float SYRUP_COST = 1.25F;
    private static final String SYRUP_DESCRIPTION = ", with Vanilla Syrup";

    public SyrupDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public float getCost() {
        return super.getCost() + SYRUP_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + SYRUP_DESCRIPTION;
    }
}
