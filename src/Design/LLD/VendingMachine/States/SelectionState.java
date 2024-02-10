package Design.LLD.VendingMachine.States;

import Design.LLD.VendingMachine.Driver.Coin;
import Design.LLD.VendingMachine.Driver.VendingMachine;
import Design.LLD.VendingMachine.Inventory.Product;

import java.util.List;

public class SelectionState implements State{

    public SelectionState(){
        System.out.println("Vending machine is currently in the selection state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        throw new RuntimeException("Cant insert coin now, first select a product");
    }

    @Override
    public void startProductSelection(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Product product = vendingMachine.getInventory().getProduct(codeNumber);

        int totalAmountPaid = 0;
        for(Coin coin : vendingMachine.getCoinList()){
            totalAmountPaid+= coin.value;
        }

        if(totalAmountPaid < product.getPrice()){
            System.out.println("Amount paid by user : " + totalAmountPaid + " is less than the product price : "+ product.getPrice());
            refundFullAmount(vendingMachine);
            //throw new RuntimeException("Insufficient money paid by the user");
        }
        else if(totalAmountPaid == product.getPrice()){
            vendingMachine.setCurrentVendingMachineState(new DispenseState(vendingMachine, codeNumber));
        }
        else{
            getChange(vendingMachine, totalAmountPaid - product.getPrice());
            vendingMachine.setCurrentVendingMachineState(new DispenseState(vendingMachine, codeNumber));
        }
    }

    @Override
    public int getChange(VendingMachine vendingMachine, int returnExtraAmount) throws Exception {
        System.out.println("Returning the extra money : " + returnExtraAmount);
        return returnExtraAmount;
    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new RuntimeException("Cant dispense product now, first select a product");
    }

    @Override
    public List<Coin> refundFullAmount(VendingMachine machine) throws Exception {
        System.out.println("Refunding the whole amount to the user");
        machine.setCurrentVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Product product) throws Exception {
        throw new RuntimeException("Cant update inventory now, first select a product");
    }
}
