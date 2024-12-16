package Design.DesignPatterns.Behavioral.ChainOfResponsibilityPattern;

public interface SupportHandler {

    void handleRequest(Request request);
    void setNextHandler(SupportHandler nextHandler);
}
