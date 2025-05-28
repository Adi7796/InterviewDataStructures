package Design.OOPS.SolidPrinciples.SingleResponsibilityPrinciple;

public class Invoice {

    private Marker marker;
    private double quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotalPrice(){
        double totalPrice = marker.price * quantity;
        return (int)totalPrice;
        /*
        if suppose tomorrow we change the logic to calculate the total price
        e.g - we introduce discount, then the logic would change
         */
    }

    // similarly we might change the logic to print invoice or save to cloud, instead of save to db
    // this would mean this Invoice class has multiple different responsibilities and if something changes in the logic
    // we will have to make multiple changes in different methods
    public void printInvoice() {

    }

    public void saveInvoiceToDB(){
        // implement logic
    }

    // Hence to counter this problem we can create 2 more classes - InvoicePrint and InvoiceDAO to take care of the
    // above to methods
}
