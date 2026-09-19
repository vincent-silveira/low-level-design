package src.transaction;

public class PostgreSQLTransactionManager implements TransactionManager {

    @Override
    public void begin() {
        System.out.println("Beginning PostgreSQL transaction");
    }

    @Override
    public void commit() {
        System.out.println("Committing PostgreSQL transaction");
    }

    @Override
    public void rollback() {
        System.out.println("Rolling back PostgreSQL transaction");
    }
}
