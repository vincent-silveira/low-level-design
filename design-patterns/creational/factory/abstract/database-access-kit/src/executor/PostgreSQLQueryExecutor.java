package src.executor;

public class PostgreSQLQueryExecutor implements QueryExecutor {

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing PostgreSQL query: " + query);
    }
}
