package LLD.VendingMachine.state;

import LLD.VendingMachine.model.Item;
import LLD.VendingMachine.model.VendingMachine;

public class DispenseMachineState extends VendingMachineState{
    public DispenseMachineState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(int id) {
        System.out.println("Item already selected...dispensing the item");
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Payment already made...dispensing the item");
    }

    @Override
    public void dispense() {
        Item item = machine.getItemMap().get(machine.getSelectedItemCode());
        item.updateQuantity(-1);
        machine.getItemMap().put(item.getId(), item);
        System.out.println("Dispensing the item");
        machine.updatedVendingMachineState(new RefundState(machine));
        machine.initiateRefund();
    }

    @Override
    public void refund() {
        System.out.println("Refund amount will be given once item is dispensed...if any");
    }
}
