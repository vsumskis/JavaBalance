package data;

/**
 * Vienas tranzakcijos irasas
 */
public class Transaction {
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    /**
     * toString metodas
     * @return grazina stirng reiksme
     */
    @Override
    public String toString() {
        return  "Description=" + description + ", amount=" + amount;
    }
}
