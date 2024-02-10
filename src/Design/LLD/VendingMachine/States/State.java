package Design.LLD.VendingMachine.States;

import Design.LLD.VendingMachine.Driver.Coin;
import Design.LLD.VendingMachine.Driver.VendingMachine;
import Design.LLD.VendingMachine.Inventory.Product;

import java.util.List;

/*
3 different states
no coin inserted state -> coin inserted state -> Dispense State -> No Coin inserted state
 */
public interface State {
    void insertCoin(VendingMachine machine, Coin coin);
    void startProductSelection(VendingMachine machine) throws Exception;
    void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    int getChange(VendingMachine vendingMachine, int returnExtraAmount) throws Exception;
    Product dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    List<Coin> refundFullAmount(VendingMachine machine) throws Exception;
    void updateInventory(VendingMachine machine, Product product) throws  Exception;
}
