package Design.OOPS.SolidPrinciples.OpenClosedPrinciple;

public class SaveInvoice {
    Invoice invoice;

    public void saveInvoiceToDB() {

    }

    public void saveInvoiceToFile() {

    }

    public void saveInvoiceToCloud(){

    }

    /*
    Here the same class is performing 3 different types of saves to 3 different types of places
    We want to segregate this behaviour into 3 different classes controlled by an interface

    InvoiceDAO implements --> SaveInvoiceToDB, SaveInvoiceToFile, SaveInvoiceToCloud
     */
}
