package src.transaction;

public class MySQLTransactionManager implements TransactionManager {

    @Override
    public void begin() {
        System.out.println("Beginning MySQL transaction");
    }

    @Override
    public void commit() {
        System.out.println("Committing MySQL transaction");
    }

    @Override
    public void rollback() {
        System.out.println("Rolling back MySQL transaction");
    }
}
