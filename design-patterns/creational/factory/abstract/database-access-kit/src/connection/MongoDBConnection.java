package src.connection;

public class MongoDBConnection implements Connection {

    @Override
    public void connect() {
        System.out.println("Connecting to MongoDB");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MongoDB");
    }
}