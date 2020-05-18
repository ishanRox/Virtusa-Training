public interface MoneyHandler{

    void setNextHandlerInChain(MoneyHandler handler);
    void handlerResponsibility(Money amount);
}