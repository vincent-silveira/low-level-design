# Original Source Code: Database Access Kit Without Design Patterns

## Overview

This implementation creates database-specific objects directly in the client code.

It does not use the **Abstract Factory Pattern**.

The purpose of this starting implementation is to provide a working database access layer that can later be refactored using the Abstract Factory Pattern.

---

## Connection.java

```java
public interface Connection {

    void connect();

    void disconnect();
}
```

---

## QueryExecutor.java

```java
public interface QueryExecutor {

    void executeQuery(String query);
}
```

---

## TransactionManager.java

```java
public interface TransactionManager {

    void begin();

    void commit();

    void rollback();
}
```

---

## MySQLConnection.java

```java
public class MySQLConnection implements Connection {

    @Override
    public void connect() {
        System.out.println("Connecting to MySQL");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MySQL");
    }
}
```

---

## MySQLQueryExecutor.java

```java
public class MySQLQueryExecutor implements QueryExecutor {

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing MySQL query: " + query);
    }
}
```

---

## MySQLTransactionManager.java

```java
public class MySQLTransactionManager implements TransactionManager {

    @Override
    public void begin() {
        System.out.println("Beginning MySQL transaction");
    }

    @Override
    public void commit() {
        System.out.println("Committing MySQL transaction");
    }

    @Override
    public void rollback() {
        System.out.println("Rolling back MySQL transaction");
    }
}
```

---

## PostgreSQLConnection.java

```java
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
```

---

## PostgreSQLQueryExecutor.java

```java
public class PostgreSQLQueryExecutor implements QueryExecutor {

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing PostgreSQL query: " + query);
    }
}
```

---

## PostgreSQLTransactionManager.java

```java
public class PostgreSQLTransactionManager implements TransactionManager {

    @Override
    public void begin() {
        System.out.println("Beginning PostgreSQL transaction");
    }

    @Override
    public void commit() {
        System.out.println("Committing PostgreSQL transaction");
    }

    @Override
    public void rollback() {
        System.out.println("Rolling back PostgreSQL transaction");
    }
}
```

---

## MongoDBConnection.java

```java
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
```

---

## MongoDBQueryExecutor.java

```java
public class MongoDBQueryExecutor implements QueryExecutor {

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing MongoDB query: " + query);
    }
}
```

---

## MongoDBTransactionManager.java

```java
public class MongoDBTransactionManager implements TransactionManager {

    @Override
    public void begin() {
        System.out.println("Beginning MongoDB transaction");
    }

    @Override
    public void commit() {
        System.out.println("Committing MongoDB transaction");
    }

    @Override
    public void rollback() {
        System.out.println("Rolling back MongoDB transaction");
    }
}
```

---

## DatabaseApplication.java

```java
public class DatabaseApplication {

    public static void main(String[] args) {

        String database = "MYSQL";

        Connection connection;
        QueryExecutor queryExecutor;
        TransactionManager transactionManager;

        if (database.equalsIgnoreCase("MYSQL")) {

            connection = new MySQLConnection();
            queryExecutor = new MySQLQueryExecutor();
            transactionManager = new MySQLTransactionManager();

        } else if (database.equalsIgnoreCase("POSTGRESQL")) {

            connection = new PostgreSQLConnection();
            queryExecutor = new PostgreSQLQueryExecutor();
            transactionManager = new PostgreSQLTransactionManager();

        } else if (database.equalsIgnoreCase("MONGODB")) {

            connection = new MongoDBConnection();
            queryExecutor = new MongoDBQueryExecutor();
            transactionManager = new MongoDBTransactionManager();

        } else {
            throw new IllegalArgumentException(
                "Invalid database: " + database
            );
        }

        connection.connect();

        transactionManager.begin();

        queryExecutor.executeQuery(
                "SELECT * FROM users"
        );

        transactionManager.commit();

        connection.disconnect();
    }
}
```

---

## Sample Output

```text
Connecting to MySQL
Beginning MySQL transaction
Executing MySQL query: SELECT * FROM users
Committing MySQL transaction
Disconnecting from MySQL
```

---

## Problems With This Approach

### 1. Direct Object Creation

The client directly creates concrete vendor-specific database objects:

```java
new MySQLConnection();
new MySQLQueryExecutor();
new MySQLTransactionManager();
```

This creates tight coupling between the client and the concrete implementations.

### 2. Conditional Logic in Client

The client contains `if-else` statements to decide which database family to create.

As more database vendors are added, this logic becomes increasingly difficult to maintain.

### 3. Components Can Be Mixed

Because the client creates each database object independently, it could accidentally create objects from different database families.

For example:

```java
connection = new MySQLConnection();
queryExecutor = new PostgreSQLQueryExecutor();
transactionManager = new MySQLTransactionManager();
```

This violates the requirement that all database objects belong to the same vendor family.

### 4. Difficult to Extend

Adding a new database vendor requires modifying the client class with another conditional branch and direct object creation calls.

### 5. Client Depends on Concrete Implementations

The client knows the names and construction details of every vendor-specific implementation.

---

## Refactoring Goal

Refactor this implementation using the **Abstract Factory Pattern**.

The final design should allow the client to obtain a complete family of related database objects from one factory.

The refactored design should support:

```text
MySQL
 ├── Connection
 ├── Query Executor
 └── Transaction Manager

PostgreSQL
 ├── Connection
 ├── Query Executor
 └── Transaction Manager

MongoDB
 ├── Connection
 ├── Query Executor
 └── Transaction Manager
```

The client should work with abstractions and should no longer directly instantiate vendor-specific database classes.

Do not add the Abstract Factory implementation to this source file. The Abstract Factory implementation is the task to be completed.
