import com.apidemo.domain.Transaction;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void transactionTest()
    {
        Transaction txn;
        txn = new Transaction("Jul10", "Expense", "-10.55", "ABC");

        // test that the Transaction date is NOT null
        assertNotNull(txn.getDate());

        // you can't test setName without having getName
        assertThat(txn.getDate(), equalTo("Jul10"));

        // you can't test setName without having getName
        txn.setAmount ("-50.00");
        assertThat(txn.getAmount(), equalTo("-50.00"));
    }

}