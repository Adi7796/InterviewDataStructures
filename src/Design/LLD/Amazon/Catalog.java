package Design.LLD.Amazon;

import Design.LLD.Amazon.Product.Product;

import java.util.HashMap;
import java.util.List;

public class Catalog implements Search {
    private HashMap<String, List<Product>> products;
    @Override
    public List<Product> searchProductByProductName(String name) {
        return null;
    }

    @Override
    public List<Product> searchProductByProductCategory(String category) {
        return null;
    }
}
