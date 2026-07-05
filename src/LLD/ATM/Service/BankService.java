package LLD.ATM.Service;

import LLD.ATM.entity.Account;
import LLD.ATM.entity.Card;

public interface BankService {

    boolean authenticate(Card card, int pin);
    int fetchBalance(Account account);
    void withdrawal(Account account, int amount);
    void deposit(Account account, int amount);
}
