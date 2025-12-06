package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LedgeEntry {
    private int id;
    private String entryDate;
    private double balance; // e.g., "Cash", "Sales", "Parts Inventory"
    private double debit;
    private double credit;
    private String description;

    public LedgeEntry(int id, String entryDate, double balance, double debit, double credit, String description) {
        this.id = id;
        this.entryDate = entryDate;
        this.balance = balance;
        this.debit = debit;
        this.credit = credit;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "LedgeEntry{" +
                "id=" + id +
                ", entryDate='" + entryDate + '\'' +
                ", balance=" + balance +
                ", debit=" + debit +
                ", credit=" + credit +
                ", description='" + description + '\'' +
                '}';
    }
}
