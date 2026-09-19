package src.factory;

import src.connection.Connection;
import src.connection.MongoDBConnection;
import src.executor.MongoDBQueryExecutor;
import src.executor.QueryExecutor;
import src.transaction.MongoDBTransactionManager;
import src.transaction.TransactionManager;

public class MongoDBDatabaseFactory implements DatabaseFactory{

    @Override
    public Connection createConnection() {
        return new MongoDBConnection();
    }

    @Override
    public QueryExecutor createQueryExecutor() {
        return new MongoDBQueryExecutor();
    }

    @Override
    public TransactionManager createTransactionManager() {
        return new MongoDBTransactionManager();
    }
}
