package LLD.VendingMachine.state;

import LLD.VendingMachine.enums.Coin;
import LLD.VendingMachine.model.Item;
import LLD.VendingMachine.model.VendingMachine;

import java.util.Map;

public class PaymentState extends VendingMachineState{

    public PaymentState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(int id) {
        System.out.println("Item already selected..please proceed to pay");
    }

    @Override
    public void insertMoney(int amount) {
        Item item = machine.getItemMap().get(machine.getSelectedItemCode());
        if (item==null){
            System.out.println("No item available");
            return;
        }
        if (amount<item.getPrice()){
            System.out.println("Not sufficient balance");
            machine.setBalance(amount);
            machine.setRefundCoins(machine.getInsertedCoins());
            machine.updatedVendingMachineState(new RefundState(machine));
            machine.initiateRefund();
            return;
        }
        int balance = amount - item.getPrice();

        Map<Coin, Integer> changeCoins = machine.getCoinInventory().getChange(balance, machine.getInsertedCoins());
        if (changeCoins == null) {
            System.out.println("Machine does not have sufficient coins to return change");
            machine.setBalance(amount);
            machine.setRefundCoins(machine.getInsertedCoins());
            machine.updatedVendingMachineState(new RefundState(machine));
            machine.initiateRefund();
            return;
        }

        System.out.println("Money received successfully...dispensing the item");
        machine.acceptInsertedCoins();
        machine.setRefundCoins(changeCoins);
        machine.deductRefundCoinsFromInventory();
        machine.setBalance(balance);
        machine.updatedVendingMachineState(new DispenseMachineState(machine));
    }

    @Override
    public void dispense() {
        System.out.println("Complete the payment first");
    }

    @Override
    public void refund() {
        System.out.println("Nothing to refund");
    }
}
