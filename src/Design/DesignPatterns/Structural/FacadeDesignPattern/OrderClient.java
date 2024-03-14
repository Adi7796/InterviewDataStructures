package Design.DesignPatterns.Structural.FacadeDesignPattern;

public class OrderClient {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade(new Invoice(), new Payment(), new ProductDAO(), new Notification());
        orderFacade.createOrder();
    }
}
