package src.factory;

public class DatabaseFactoryRegistry {

    public static DatabaseFactory getDatabaseFactory(String database){
        if(database == null || database.isBlank()){
            throw new IllegalArgumentException("Invalid database: Cannot be empty");
        }

        return switch (database.toUpperCase()){
            case "MYSQL" -> new MySQLDatabaseFactory();
            case "POSTGRESQL" -> new PostgreSQLDatabaseFactory();
            case "MONGODB" -> new MongoDBDatabaseFactory();
            default -> throw new IllegalArgumentException("Invalid database: " + database);
        };
    }
}
