package LLD.ATM.Service;

import LLD.ATM.Stratergy.CashDispenser;
import LLD.ATM.Stratergy.Dispenser100;
import LLD.ATM.Stratergy.Dispenser200;
import LLD.ATM.Stratergy.Dispenser50;
import LLD.ATM.entity.Account;
import LLD.ATM.entity.Card;
import lombok.Getter;

public class ATM {
    @Getter
    private Card currentCard;
    private BankService bankService;
    private CashDispenser cashDispenser;

    public ATM(BankService bankService) {
        this.bankService = bankService;
        CashDispenser d200 = new Dispenser200(null);
        CashDispenser d100 = new Dispenser100(d200);
        this.cashDispenser = new Dispenser50(d100);
    }

    public void authenticate(Card card, int pin){
        if (bankService.authenticate(card,pin)) {
            System.out.println("PIN successfully matched");
        }else{
            throw new RuntimeException("Incorrect PIN");
        }
        this.currentCard = card;
    }

    public int checkBalance(Account account){
        return bankService.fetchBalance(account);
    }

    public void deposit(Account account, int amount){
        bankService.deposit(account,amount);
    }

    public void withdraw(Account account, int amount){
        bankService.withdrawal(account, amount);
    }

}
