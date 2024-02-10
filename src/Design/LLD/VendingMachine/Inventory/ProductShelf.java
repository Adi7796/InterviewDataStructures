package Design.LLD.VendingMachine.Inventory;

public class ProductShelf {
    Product product;

    int codeNumber;

    boolean soldOut;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }
}
