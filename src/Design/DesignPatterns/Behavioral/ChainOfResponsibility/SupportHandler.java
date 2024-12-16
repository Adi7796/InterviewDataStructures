package Design.DesignPatterns.Behavioral.ChainOfResponsibility;

public interface SupportHandler {

    void handleRequest(Request request);
    void setNextHandler(SupportHandler nextHandler);
}
