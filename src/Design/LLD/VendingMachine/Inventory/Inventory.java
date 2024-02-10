package Design.LLD.VendingMachine.Inventory;

public class Inventory {

    private ProductShelf[] productShelf;
    private int remainingShelfCapacity;

    private int shelfCapacity;

    public Inventory(int shelfCapacity) {
        productShelf = new ProductShelf[shelfCapacity];
        this.remainingShelfCapacity = shelfCapacity;
        addProductsToEmptyInventory(shelfCapacity);
    }

    public ProductShelf[] getProductShelf() {
        return productShelf;
    }

    public void setProductShelf(ProductShelf[] productShelf) {
        this.productShelf = productShelf;
    }

    public int getShelfCapacity() {
        return shelfCapacity;
    }

    public void setShelfCapacity(int shelfCapacity) {
        this.shelfCapacity = shelfCapacity;
    }

    public void addProductsToEmptyInventory(int shelfCapacity){
        int codeNumber = 101;
        for(int i=0;i<shelfCapacity; i++){
            ProductShelf newProductShelf = new ProductShelf();
            Product product = new Product();
            if(i<3){
                product.setProductType(ProductType.COKE);
                product.setPrice(10);
            }
            else if(i>=3 && i<6){
                product.setProductType(ProductType.CHIPS);
                product.setPrice(15);
            }
            else if(i>=6 && i<9){
                product.setProductType(ProductType.JUICE);
                product.setPrice(20);
            }
            else{
                product.setProductType(ProductType.WATER);
                product.setPrice(12);
            }
            newProductShelf.setProduct(product);
            newProductShelf.setSoldOut(false);
            newProductShelf.setCodeNumber(codeNumber);

            productShelf[i] = newProductShelf;
            remainingShelfCapacity--;
            codeNumber++;
        }
    }

    public Product getProduct(int codeNumber){
        for(ProductShelf productShelf1 : productShelf){
            if(productShelf1.getCodeNumber() == codeNumber){
                if(productShelf1.isSoldOut())
                    throw new RuntimeException(String.format("Product %s is sold out", productShelf1.getProduct().productType));
                else
                    return productShelf1.getProduct();
            }
        }
        throw new RuntimeException("Invalid Code");
    }

    public void displayInventory(){
        for(ProductShelf productShelf1 : productShelf){
            System.out.println(productShelf1.getCodeNumber() + " :: " + productShelf1.getProduct().productType +
                    " :: " + productShelf1.getProduct().getPrice() + " :: " + productShelf1.isSoldOut());
        }
    }

    public void addProductToExistingInventory(Product product){
        if(remainingShelfCapacity == 0)
            throw new RuntimeException("Cant add more products to inventory as there is no space left");
        else{

        }
    }

    public void updateSoldOutProduct(int codeNumber){
        for(ProductShelf productShelf1 : productShelf){
            if(productShelf1.getCodeNumber() == codeNumber)
                productShelf1.setSoldOut(true);
        }
    }
}
