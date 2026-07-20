package LLD.ParkingSystem;

import LLD.ParkingSystem.PaymentStrategy.PaymentService;

import java.time.LocalDateTime;

public class Payment{
    private int ticketId;
    private int amount;
    private PaymentStatus paymentStatus;
    private LocalDateTime paidAt;
    private PaymentService paidUsing;

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

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public PaymentService getPaidUsing() {
        return paidUsing;
    }

    public void setPaidUsing(PaymentService paidUsing) {
        this.paidUsing = paidUsing;
    }
}
