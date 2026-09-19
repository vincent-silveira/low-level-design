package src.factory;

import src.connection.Connection;
import src.connection.MySQLConnection;
import src.executor.MySQLQueryExecutor;
import src.executor.QueryExecutor;
import src.transaction.MySQLTransactionManager;
import src.transaction.TransactionManager;

public class MySQLDatabaseFactory implements DatabaseFactory{

    @Override
    public Connection createConnection() {
        return new MySQLConnection();
    }

    @Override
    public QueryExecutor createQueryExecutor() {
        return new MySQLQueryExecutor();
    }

    @Override
    public TransactionManager createTransactionManager() {
        return new MySQLTransactionManager();
    }
}
