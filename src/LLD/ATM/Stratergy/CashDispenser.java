package LLD.ATM.Stratergy;

import lombok.Setter;

public abstract class CashDispenser {
    public CashDispenser cashDispenser;
    private final int noteValue;
    @Setter
    private int numberOfNotes;

    public CashDispenser(CashDispenser cashDispenser, int noteValue) {
        this.cashDispenser = cashDispenser;
        this.noteValue = noteValue;
    }

    public void withdraw(int amount) {
        int requiredNotes = amount / noteValue;
        int notesToDispense = Math.min(requiredNotes,this.numberOfNotes);
        int remainingAmount = amount - (notesToDispense * noteValue);
        if (notesToDispense>0) {
            this.numberOfNotes = this.numberOfNotes - notesToDispense;
        }
        if (remainingAmount>0) {
            if (cashDispenser != null) {
                cashDispenser.withdraw(remainingAmount);
            } else {
                throw new IllegalArgumentException("No suitable cash dispenser amount found");
            }
        }
    }

}
