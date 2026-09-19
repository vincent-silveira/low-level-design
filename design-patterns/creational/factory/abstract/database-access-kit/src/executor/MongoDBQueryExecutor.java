package src.executor;

public class MongoDBQueryExecutor implements QueryExecutor {

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing MongoDB query: " + query);
    }
}
