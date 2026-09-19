package src.executor;

public class MySQLQueryExecutor implements QueryExecutor {

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing MySQL query: " + query);
    }
}
