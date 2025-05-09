package com.expensetracker.models;

import java.util.Objects;
import java.time.LocalDate;

public class Transaction {
    private int id;
    private int userId;
    private String type;
    private String category;
    private double amount;
    private String date;
    private String description;

    public Transaction(int userId, String type, String category,
                       double amount, String date, String description) {
        this(-1, userId, type, category, amount, date, description); // -1 for new unsaved transactions
    }
    // Full constructor
    public Transaction(int id, int userId, String type, String category,
                       double amount, String date, String description) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // Getters (required for DatabaseManager)
    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getType() { return type; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    public String getDescription() { return description; }

    // toString() for debugging
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    // equals() and hashCode() for comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id &&
                userId == that.userId &&
                Double.compare(that.amount, amount) == 0 &&
                Objects.equals(type, that.type) &&
                Objects.equals(category, that.category) &&
                Objects.equals(date, that.date) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, type, category, amount, date, description);
    }
}
