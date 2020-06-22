public class ChainOfResponsibility {

    public static void main(String[] args) {

        MoneyHandler handler1 = new ThousandHandler();
        MoneyHandler handler2 = new HundredHandler();
        MoneyHandler handler3 = new FinalHandler();

        handler1.setNextHandlerInChain(handler2);
        handler2.setNextHandlerInChain(handler3);

        handler1.handlerResponsibility(new Money(1160));
        System.out.println();
        handler1.handlerResponsibility(new Money(5615));

    }
}