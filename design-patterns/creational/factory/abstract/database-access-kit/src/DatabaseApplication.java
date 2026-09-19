package src;

import src.connection.Connection;
import src.executor.QueryExecutor;
import src.factory.DatabaseFactory;
import src.factory.DatabaseFactoryRegistry;
import src.transaction.TransactionManager;

public class DatabaseApplication {

    public static void main(String[] args) {

        String database = "MYSQL";

        DatabaseFactory databaseFactory = DatabaseFactoryRegistry.getDatabaseFactory(database);

        Connection connection = databaseFactory.createConnection();
        QueryExecutor queryExecutor = databaseFactory.createQueryExecutor();
        TransactionManager transactionManager = databaseFactory.createTransactionManager();


        connection.connect();

        transactionManager.begin();

        queryExecutor.executeQuery(
                "SELECT * FROM users"
        );

        transactionManager.commit();

        connection.disconnect();
    }
}
