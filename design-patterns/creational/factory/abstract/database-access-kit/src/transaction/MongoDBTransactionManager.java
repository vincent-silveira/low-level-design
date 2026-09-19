package src.transaction;

public class MongoDBTransactionManager implements TransactionManager {

    @Override
    public void begin() {
        System.out.println("Beginning MongoDB transaction");
    }

    @Override
    public void commit() {
        System.out.println("Committing MongoDB transaction");
    }

    @Override
    public void rollback() {
        System.out.println("Rolling back MongoDB transaction");
    }
}
