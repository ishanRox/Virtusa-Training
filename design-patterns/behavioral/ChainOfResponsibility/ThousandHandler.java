public class ThousandHandler implements MoneyHandler {
    private MoneyHandler nextHandler;

    @Override
    public void setNextHandlerInChain(MoneyHandler handler) {
        this.nextHandler = handler;

    }

    @Override
    public void handlerResponsibility(Money amount) {
        if (amount.getCashAmount() >= 1000) {
            System.out.println("here you have " + amount.getCashAmount() / 1000 + " one thousand  notes");
            if (amount.getCashAmount() % 1000 != 0) {
                // this handler did the work but still there some more to be done
                //get the remainder after dividing by 1000 and set to this object
                amount.setCashAmount(amount.getCashAmount() % 1000);
                this.nextHandler.handlerResponsibility(amount);
            }
        } else {
            // this handler cant deal with this money and hand over the responsibility to
            // other handler
            this.nextHandler.handlerResponsibility(amount);

        }

    }

}