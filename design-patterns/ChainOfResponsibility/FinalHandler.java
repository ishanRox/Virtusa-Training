public class FinalHandler implements MoneyHandler {
    private MoneyHandler nextHandler;

    @Override
    public void setNextHandlerInChain(MoneyHandler handler) {
        this.nextHandler = handler;

    }

    @Override
    public void handlerResponsibility(Money amount) {
       System.out.println("Here your remaining money in other notes "+amount.getCashAmount());

    }

}