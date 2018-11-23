package data;

import static org.junit.Assert.*;

public class TransactionTest {
    private Transaction transaction = new Transaction("tranzakcija", 100);

    @org.junit.Test
    public void getDescription() {
        assertEquals("tranzakcija", transaction.getDescription());
    }

    @org.junit.Test
    public void getAmount() {
        assertEquals(100, transaction.getAmount(), 2);
    }

    @org.junit.Test
    public void toStringtest() {
        assertEquals("Description=tranzakcija, amount=" + (double) 100, transaction.toString());
        assertTrue(transaction.toString().contains("tranzak"));
        assertTrue(transaction.toString().contains("100"));
    }
}