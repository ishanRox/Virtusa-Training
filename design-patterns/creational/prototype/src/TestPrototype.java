public class TestPrototype {

    public static void main(String[] args) {
        MilkTypeRegistry milkTypeRegistry= new MilkTypeRegistry();

        Milk lassi = milkTypeRegistry.getMilk("lassi");

        lassi.setCondiments("spice");
        System.out.println(lassi);

        Milk faluda = milkTypeRegistry.getMilk("faluda");
        System.out.println(faluda);


        System.out.println(milkTypeRegistry.getMilk(""));

    }
}
