package src.transaction;

public interface TransactionManager {

    void begin();

    void commit();

    void rollback();
}
