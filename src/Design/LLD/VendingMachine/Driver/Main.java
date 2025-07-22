package Design.LLD.VendingMachine.Driver;

import Design.LLD.VendingMachine.Inventory.Inventory;
import Design.LLD.VendingMachine.States.State;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try{
            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            Inventory inventory = vendingMachine.getInventory();
            //inventory.addProductsToEmptyInventory(inventory.getShelfCapacity());

            inventory.displayInventory();

            System.out.println("|");
            System.out.println("Inserting Coins");
            System.out.println("|");

            vendingMachine.getCurrentVendingMachineState().insertCoin(vendingMachine, Coin.TEN);
            System.out.println("|");
            vendingMachine.getCurrentVendingMachineState().insertCoin(vendingMachine, Coin.FIVE);
            System.out.println("|");
            vendingMachine.getCurrentVendingMachineState().insertCoin(vendingMachine, Coin.TEN);
            System.out.println("|");
            System.out.println("Current Coins List : "+ vendingMachine.getCoinList());
            System.out.println("|");

            vendingMachine.getCurrentVendingMachineState().startProductSelection(vendingMachine);
            System.out.println("|");
            vendingMachine.getCurrentVendingMachineState().chooseProduct(vendingMachine, 109);

            System.out.println("|");
            inventory.displayInventory();

        } catch(Exception e){
            System.out.println("Error occurred in the system");
        }
    }
}
