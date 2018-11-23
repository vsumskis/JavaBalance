package support;

import data.Book;
import data.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Tranzakciju knygos irasymas/skaitymas i/is tekstini faila.
 */
class Storage {
    private final String FILENAME = "money.txt";

    Book load() {
        Book book = new Book();
        //tarp skliaustu galima parasyti tik klases kurios implementuoja CLOSABLE interfeisa. pvz FileRader
        try (FileReader fileReader = new FileReader(FILENAME);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String description;

            while (null != (description = reader.readLine())) {
                double amount = Double.parseDouble(reader.readLine());
                book.addTransaction(new Transaction(description, amount));
            }
            return book;
        } catch (IOException e) {
            return book;
        }
    }

    /**
     * Boolean metodas
     *
     * @param book paduodama kolekcija
     * @return grazina true jei issaugoti pavyksta ir false - jei nepavyksta
     */
    boolean save(Book book) {
        try {
            FileWriter writer = new FileWriter(FILENAME);
            for (Transaction transaction : book.getTransactions())
                writer.write(transaction.getDescription() + "\n" + transaction.getAmount() + "\n");
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }
}
