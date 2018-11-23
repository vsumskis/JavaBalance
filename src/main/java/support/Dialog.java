package support;

import java.util.Scanner;

/**
 * Vartotojo sasajos organizavimas
 * Informacijos isvedimas i ekrana ir ivedimas is klaviaturos
 */
class Dialog {
    private Scanner scanner = new Scanner(System.in); //galima ir konstruktoriuje ta daryti.


     void println(String message) {
        System.out.println(message);
    }

     private void print(String message) {
        System.out.print(message);
    }

    private String input() {
        return scanner.nextLine();
    }

    /**
     * ivedimas su teksto isvedimu i ekrana
     *
     * @param message tekstas, kuris isvedamas i ekrana
     * @return nuskaitymas is klaviaturos
     */
     String input(String message) {
        print(message);
        return input();
    }
}