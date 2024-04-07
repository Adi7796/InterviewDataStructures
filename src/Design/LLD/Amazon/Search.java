package Design.LLD.Amazon;

import Design.LLD.Amazon.Product.Product;

import java.util.ArrayList;
import java.util.List;

public interface Search {
    public List<Product> searchProductByProductName(String name);
    public List<Product> searchProductByProductCategory(String category);
}
