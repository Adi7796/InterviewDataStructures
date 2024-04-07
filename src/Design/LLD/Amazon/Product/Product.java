package Design.LLD.Amazon.Product;

import Design.LLD.Amazon.Account;

import java.util.List;

public class Product {
    private String productId;
    private String productName;
    private String description;
    private double price;
    private ProductCategory productCategory;
    private int availableItemCount;
    private List<ProductReview> productReviewList;
    private Account account;

    public int getAvailableCount(){ return availableItemCount ;}
    public boolean updateAvailableCount(int newCount) {
        availableItemCount += newCount;
        return true; }

    public boolean updatePrice(double newPrice){
        price = newPrice;
        return true;
    }
}
