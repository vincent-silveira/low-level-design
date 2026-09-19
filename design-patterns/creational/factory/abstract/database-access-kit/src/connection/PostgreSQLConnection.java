package src.connection;

public class PostgreSQLConnection implements Connection {

    @Override
    public void connect() {
        System.out.println("Connecting to PostgreSQL");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from PostgreSQL");
    }
}