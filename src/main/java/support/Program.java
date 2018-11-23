package support;

import data.Book;
import data.Transaction;

/**
 * Pagridinis programos algoritmas
 * Maniu punkto pasirinkimas ir atitinkamu veiksmu vykdymas
 */
public class Program {
    private Book book;
    private Dialog dialog;
    private Storage storage;

    /**
     * Cia prasideda programos logika, be parametru.
     */
    public void start() {
        doInit();
        while (true) {
            doShowMenu();
            String item = dialog.input("Iveskite meniu punkta: ");
            switch (item) {
                case "1": doAddCredit(); break;
                case "2": doAddDebit(); break;
                case "3": doShowAllTransactions(); break;
                case "4": doShowbalance(); break;
                case "0": if (!doExit()) break;
                    return;
                default: dialog.println("Iveskite meniu punkta nuo 0 iki 4");
                    break;
            }
        }
    }

    private void doShowMenu() {
        dialog.println("-= Pagrindinis Meniu =-");
        dialog.println("1. Pajamu registravimas");
        dialog.println("2. Islaidu registravimas");
        dialog.println("3. Visu tranzakciju isvedimas");
        dialog.println("4. Bendro balanso skaiciavimas");
        dialog.println("0. Duomenu issaugojimas ir isejimas");
    }

    private void doInit() {
        dialog = new Dialog();
        storage = new Storage();
        dialog.println("Sveiki atvyke i didziaja knyga!");
        book = storage.load();
    }

    private void doAddCredit() {
        String description = dialog.input("Iveskite pajamu komentara ");
        double amount = Double.parseDouble(dialog.input("Iveskite suma: "));
        doTransaction(description, amount);
    }

    private void doAddDebit() {
        String description = dialog.input("Iveskite islaidu komentara ");
        double amount = Double.parseDouble(dialog.input("Iveskite suma: "));
        doTransaction(description, -amount);

    }

    private void doTransaction(String description, double amount) {
        book.addTransaction(new Transaction(description, amount));
    }

    private void doShowAllTransactions() {
        if (book.getTransactions().size() == 0)
            dialog.println("Tranzakciju sarasas yra tuscias");
        int nr = 1;
        for (Transaction transaction : book.getTransactions()) {
            dialog.println((nr++) + ")" + transaction);
        }
    }

    private void doShowbalance() {
        dialog.println("Bendras balansas: " + (book.getBalance()));
    }

    private boolean doExit() {
        if (storage.save(book)) {
            dialog.println("Tranzakciju zurnalas issaugotas, sekmes!");
            return true;
        } else {
            dialog.println("Nepavyko issaugoti tranzakciju zurnalo!");
            return false;
        }
    }
}