package Design.DesignPatterns.Structural.FacadeDesignPattern;

public class ProductDAO {

    public Product getProduct(String name, int productId){
        return new Product(productId, name);
    }
}
