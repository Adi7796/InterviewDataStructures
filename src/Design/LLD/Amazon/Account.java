package Design.LLD.Amazon;

import Design.LLD.Amazon.Enums.Address;
import Design.LLD.Amazon.Payment.Card;
import Design.LLD.Amazon.Payment.Netbanking;

import java.util.List;

public class Account {
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    List<Card> cardsList;
    List<Netbanking> accountsList;

    public Address getShippingAddress(){ return new Address(); }
    public boolean addProduct(){ return true; }
}
