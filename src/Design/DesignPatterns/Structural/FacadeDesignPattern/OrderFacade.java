package Design.DesignPatterns.Structural.FacadeDesignPattern;

public class OrderFacade {
    private Invoice invoiceService;
    private Payment paymentService;
    private ProductDAO productDAOService;
    private Notification notificationService;

    public OrderFacade(Invoice invoiceService, Payment paymentService, ProductDAO productDAOService, Notification notificationService) {
        this.invoiceService = invoiceService;
        this.paymentService = paymentService;
        this.productDAOService = productDAOService;
        this.notificationService = notificationService;
    }

    public void createOrder(){
        Product product = productDAOService.getProduct("New product", 1122);
        paymentService.makePayment();
        invoiceService.generateInvoice();
        notificationService.sendNotification();

        System.out.println("Order created successfully for : " + product.getProductName());
    }
}
