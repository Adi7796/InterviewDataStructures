package Design.LLD.VendingMachine.States;

import Design.LLD.VendingMachine.Driver.Coin;
import Design.LLD.VendingMachine.Driver.VendingMachine;
import Design.LLD.VendingMachine.Inventory.Product;

import java.util.List;

public class CoinInsertedState implements State{

    public CoinInsertedState(VendingMachine vendingMachine, Coin coin){
        System.out.println("Vending machine is currently in the coin inserted state");
        insertCoin(vendingMachine, coin);
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("Accepted coin " + coin.name());
        machine.getCoinList().add(coin);

    }

    @Override
    public void startProductSelection(VendingMachine machine) throws Exception {
        machine.setCurrentVendingMachineState(new SelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new RuntimeException("Cant choose product now, first start product selection");
    }

    @Override
    public int getChange(VendingMachine vendingMachine, int returnExtraAmount) throws Exception {
        throw new RuntimeException("Cant get change now, first start product selection");
    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new RuntimeException("Cant dispense product now, first start product selection");
    }

    @Override
    public List<Coin> refundFullAmount(VendingMachine machine) throws Exception {
        System.out.println("Refunding the whole amount");
        machine.setCurrentVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Product product) throws Exception {
        throw new RuntimeException("Cant update inventory now, first start product selection");
    }
}
