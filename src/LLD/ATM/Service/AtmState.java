package LLD.ATM.Service;

import LLD.ATM.entity.Card;
import LLD.ATM.enums.TransactionType;

public interface AtmState {
    void insertCard(Card card);
    void checkPin(int pin);
    void selectTransactionType(TransactionType transactionType);
    void ejectCard();
}
