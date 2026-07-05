package LLD.ATM.Service.impl;

import LLD.ATM.Service.BankService;
import LLD.ATM.entity.Account;
import LLD.ATM.entity.Card;

public class BankServiceImpl implements BankService {
    @Override
    public boolean authenticate(Card card, int pin) {
        return card.getPin() == pin;
    }

    @Override
    public int fetchBalance(Account account) {
        return account.getBalance();
    }

    @Override
    public void withdrawal(Account account, int amount) {
        account.withdrawBalance(amount);
    }

    @Override
    public void deposit(Account account, int amount) {
        account.depositBalance(amount);
    }


}
