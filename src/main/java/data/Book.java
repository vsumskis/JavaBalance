package data;

import java.util.ArrayList;
/**
 * Viso tranzakciju saraso kolekcija
 */
public class Book {
    private ArrayList<Transaction> list;

    public Book() {
        list = new ArrayList<>();
    }

    public void addTransaction (Transaction transaction) {
        list.add(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return list;
    }

    /**
     * Metodas gauti bendra balansa
     * @return grazina double reiksme - balansa.
     */
    public double getBalance() {
        if (list.size() == 0)
            return 0;
        double balance = 0;
        for (Transaction transaction : list) {
            balance += transaction.getAmount();

        }
        return balance;
    }
}