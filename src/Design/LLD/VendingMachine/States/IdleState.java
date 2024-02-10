package Design.LLD.VendingMachine.States;

import Design.LLD.VendingMachine.Driver.Coin;
import Design.LLD.VendingMachine.Driver.VendingMachine;
import Design.LLD.VendingMachine.Inventory.Product;

import java.util.List;

public class IdleState implements State{

    public IdleState(){
        System.out.println("Vending machine is currently in the idle state");
    }
    public IdleState(VendingMachine machine){
        System.out.println("Vending machine is currently in the idle state");
    }
    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        machine.setCurrentVendingMachineState(new CoinInsertedState(machine, coin));
    }

    @Override
    public void startProductSelection(VendingMachine machine) throws Exception {
        System.out.println("Cant select product now, insert coins first");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new RuntimeException("Cant choose product now, insert coins first");
    }

    @Override
    public int getChange(VendingMachine vendingMachine, int returnExtraAmount) throws Exception {
        throw new RuntimeException("Can't give change now, insert coins first");
    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new RuntimeException("Cant dispense product now, insert coins first");
    }

    @Override
    public List<Coin> refundFullAmount(VendingMachine machine) throws Exception {
        throw new RuntimeException("Cant refund amount now, insert coins first");
    }

    @Override
    public void updateInventory(VendingMachine machine, Product product) throws Exception {
        machine.getInventory().addProductToExistingInventory(product);
    }
}
