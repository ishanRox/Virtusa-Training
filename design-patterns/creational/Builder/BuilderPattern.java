public class BuilderPattern {
    public static void main(String[] args) {
        System.out.println("Using the Builder class");

        Pizza.PizzaBuilder builder = new Pizza.PizzaBuilder();
        Pizza chickenLarge = builder.addCheese(true).setMeatType("Chicken").setSize("Large").build();
        Pizza porkMedium = builder.addCheese(false).setMeatType("Pork").setSize("Medium").addSauce(true).build();

        System.out.println(chickenLarge);
        System.out.println(porkMedium);

    }
}

/**
 * Pizza
 * 
 */
 class Pizza {

    private boolean cheese;
    private boolean hotSauce;
    private String size;
    private String meatType;

    public Pizza(PizzaBuilder build) {
        this.cheese = build.cheese;
        this.hotSauce = build.hotSauce;
        this.size = build.size;
        this.meatType = build.meatType;

    }

    static class PizzaBuilder {
        private boolean cheese;
        private boolean hotSauce;
        private String size;
        private String meatType;

        public PizzaBuilder addCheese(boolean check) {
            this.cheese = check;
            return this;
        }

        public PizzaBuilder addSauce(boolean check) {
            this.hotSauce = check;
            return this;
        }

        public PizzaBuilder setSize(String size) {
            this.size = size;
            return this;
        }

        public PizzaBuilder setMeatType(String type) {
            this.meatType = type;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return "Pizza is with " +( (this.cheese) ? " cheese "
        : "out cheese ") + " and with" + ((this.hotSauce) ? " hot sauce "
        : "out hot sauce " )+ "with " + this.meatType + ".And this is a " + this.size + " size Pizza";
    }

}