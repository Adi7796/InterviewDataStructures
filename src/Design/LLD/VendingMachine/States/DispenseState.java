package Design.LLD.VendingMachine.States;

import Design.LLD.VendingMachine.Driver.Coin;
import Design.LLD.VendingMachine.Driver.VendingMachine;
import Design.LLD.VendingMachine.Inventory.Product;
import Design.LLD.VendingMachine.Inventory.ProductShelf;

import java.util.List;

public class DispenseState implements State{

    public DispenseState(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Vending machine is currently in the dispense state");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        throw new RuntimeException("Cant insert coin now, product being dispensed");
    }

    @Override
    public void startProductSelection(VendingMachine machine) throws Exception {
        throw new RuntimeException("Cant start product selection now, product being dispensed");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new RuntimeException("Cant choose product now, product being dispensed");
    }

    @Override
    public int getChange(VendingMachine vendingMachine, int returnExtraAmount) throws Exception {
        throw new RuntimeException("Cant get change now, product being dispensed");
    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Product product = vendingMachine.getInventory().getProduct(codeNumber);
        vendingMachine.getInventory().updateSoldOutProduct(codeNumber);
        vendingMachine.setCurrentVendingMachineState(new IdleState(vendingMachine));
        System.out.println("Product has been dispensed :: " +  product.getProductType().name());
        return product;
    }

    @Override
    public List<Coin> refundFullAmount(VendingMachine machine) throws Exception {
        throw new Exception("refund can not be happen in Dispense state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Product product) throws Exception {
        throw new Exception("inventory can not be updated in Dispense state");
    }
}
