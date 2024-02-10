package Design.LLD.VendingMachine.Driver;

import Design.LLD.VendingMachine.Inventory.Inventory;
import Design.LLD.VendingMachine.States.IdleState;
import Design.LLD.VendingMachine.States.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class VendingMachine {

    private State currentVendingMachineState;
    private Inventory inventory;
    private List<Coin> coinList;

    static private final Integer SHELF_CAPACITY = 12;
    public VendingMachine(){
         currentVendingMachineState = new IdleState();
         inventory = new Inventory(SHELF_CAPACITY);
         coinList = new ArrayList<>();
    }

    public State getCurrentVendingMachineState() {
        return currentVendingMachineState;
    }

    public void setCurrentVendingMachineState(State currentVendingMachineState) {
        this.currentVendingMachineState = currentVendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
