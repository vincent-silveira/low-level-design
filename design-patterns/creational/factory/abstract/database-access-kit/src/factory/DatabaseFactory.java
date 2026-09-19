package src.factory;

import src.connection.Connection;
import src.executor.QueryExecutor;
import src.transaction.TransactionManager;

public interface DatabaseFactory {

    Connection createConnection();

    QueryExecutor createQueryExecutor();

    TransactionManager createTransactionManager();
}
