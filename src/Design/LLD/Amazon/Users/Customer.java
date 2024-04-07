package Design.LLD.Amazon.Users;

import Design.LLD.Amazon.ShoppingCart.ShoppingCart;

public abstract class Customer {
    private ShoppingCart shoppingCart;

    public abstract ShoppingCart getShoppingCart();
}

