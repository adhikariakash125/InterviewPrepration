package LLD.VendingMachine.state;

import LLD.VendingMachine.model.Item;
import LLD.VendingMachine.model.VendingMachine;

public class IdleState extends VendingMachineState{

    public IdleState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(int id) {
        Item item = machine.getItemMap().get(id);
        if (item==null || item.getQuantity()<=0){
            System.out.println("Item not in stock or invalid item");
            return;
        }
        System.out.println("Selected item: " + item.getName());
        System.out.println("Proceed to pay");
        machine.setSelectedItemCode(item.getId());
        machine.updatedVendingMachineState(new PaymentState(machine));
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Select the item first");
    }

    @Override
    public void dispense() {
        System.out.println("Nothing to dispense..select an item first");
    }

    @Override
    public void refund() {
        System.out.println("No amount to refund");
    }
}
