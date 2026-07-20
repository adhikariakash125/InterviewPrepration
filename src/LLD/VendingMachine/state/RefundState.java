package LLD.VendingMachine.state;

import LLD.VendingMachine.enums.Coin;
import LLD.VendingMachine.model.VendingMachine;

import java.util.Map;

public class RefundState extends VendingMachineState{

    public RefundState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(int id) {
        System.out.println("Item already dispensed...processing refund if any");
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Payment already made...processing refund if any");
    }

    @Override
    public void dispense() {
        System.out.println("Item already dispensed...processing refund if any");
    }

    @Override
    public void refund() {
        if (machine.getBalance()<=0){
            System.out.println("No amount to refund");
            machine.reset();
            machine.updatedVendingMachineState(new IdleState(machine));
            return;
        }
        System.out.println("Refund amount " + machine.getBalance() + " is processed");
        printRefundCoins(machine.getRefundCoins());
        machine.reset();
        machine.updatedVendingMachineState(new IdleState(machine));
        System.out.println("Refund has been completed");
    }

    private void printRefundCoins(Map<Coin, Integer> refundCoins) {
        if (refundCoins.isEmpty()) {
            return;
        }

        System.out.println("Refund coins: " + refundCoins);
    }
}
