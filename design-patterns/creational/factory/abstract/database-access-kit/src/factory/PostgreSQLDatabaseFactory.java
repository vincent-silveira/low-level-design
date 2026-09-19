package src.factory;

import src.connection.Connection;
import src.connection.PostgreSQLConnection;
import src.executor.PostgreSQLQueryExecutor;
import src.executor.QueryExecutor;
import src.transaction.PostgreSQLTransactionManager;
import src.transaction.TransactionManager;

public class PostgreSQLDatabaseFactory implements DatabaseFactory{
    @Override
    public Connection createConnection() {
        return new PostgreSQLConnection();
    }

    @Override
    public QueryExecutor createQueryExecutor() {
        return new PostgreSQLQueryExecutor();
    }

    @Override
    public TransactionManager createTransactionManager() {
        return new PostgreSQLTransactionManager();
    }
}
