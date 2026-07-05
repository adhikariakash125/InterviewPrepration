package LLD.ATM.Service.impl;

import LLD.ATM.Service.AtmState;
import LLD.ATM.entity.Card;
import LLD.ATM.enums.TransactionType;

public class IdleState implements AtmState {
    @Override
    public void insertCard(Card card) {

    }

    @Override
    public void checkPin(int pin) {

    }

    @Override
    public void selectTransactionType(TransactionType transactionType) {

    }

    @Override
    public void ejectCard() {

    }
}
