package LLD.ATM.entity;

public class User {
    private String id;
    private Card card;
    private Account account;

    public User(String id, Card card, Account account) {
        this.id = id;
        this.card = card;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
