package LLD.ParkingSystem;

import LLD.ParkingSystem.PaymentStrategy.PaymentService;

import java.time.LocalDateTime;

public class Payment{
    private final int ticketId;
    private final int amount;
    private final PaymentStatus paymentStatus;
    private final LocalDateTime paidAt;
    private final PaymentService paidUsing;

    public Payment(int ticketId, int amount, PaymentStatus paymentStatus, PaymentService paidUsing) {
        this.ticketId = ticketId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paidAt = LocalDateTime.now();
        this.paidUsing = paidUsing;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public PaymentService getPaidUsing() {
        return paidUsing;
    }
}
