public class HundredHandler implements MoneyHandler {
    private MoneyHandler nextHandler;

    @Override
    public void setNextHandlerInChain(MoneyHandler handler) {
        this.nextHandler = handler;

    }

    @Override
    public void handlerResponsibility(Money amount) {
        if (amount.getCashAmount() >= 100) {
            System.out.println("here you have " + amount.getCashAmount() / 100 + " one Hundred  notes");
            if (amount.getCashAmount() % 100 != 0) {
                // this handler did the work but still there some more to be done
                // get the remainder after dividing by 100 and set to this object
                amount.setCashAmount(amount.getCashAmount() % 100);
                this.nextHandler.handlerResponsibility(amount);
            }
        } else {
            // this handler cant deal with this money and hand over the responsibility to
            // other handler
            this.nextHandler.handlerResponsibility(amount);

        }

    }

}