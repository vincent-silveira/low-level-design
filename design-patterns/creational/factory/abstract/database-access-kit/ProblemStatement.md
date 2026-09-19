# Problem Statement: Database Access Kit

## Scenario

You are developing a database abstraction layer for an application that supports multiple database vendors.

The application needs to work with:

- MySQL
- PostgreSQL
- MongoDB

Each database vendor provides its own implementation of the following related database objects:

- Connection
- Query Executor
- Transaction Manager

The application should be able to create a complete set of database objects for one vendor without the client needing to know the concrete implementation classes.

## Objective

Build a database access kit using the **Abstract Factory Pattern**.

The abstract factory should define methods for creating a family of related database objects. Each concrete database factory should create the objects belonging to its database vendor.

For example:

```text
MySQLDatabaseFactory
 ├── MySQLConnection
 ├── MySQLQueryExecutor
 └── MySQLTransactionManager
```

## Requirements

1. Create a common interface for `Connection`.
2. Create a common interface for `QueryExecutor`.
3. Create a common interface for `TransactionManager`.
4. Create separate implementations of each database object for MySQL, PostgreSQL, and MongoDB.
5. Create a common `DatabaseFactory` interface that declares factory methods for creating:
   - `Connection`
   - `QueryExecutor`
   - `TransactionManager`
6. Create a `MySQLDatabaseFactory` that creates MySQL database objects.
7. Create a `PostgreSQLDatabaseFactory` that creates PostgreSQL database objects.
8. Create a `MongoDBDatabaseFactory` that creates MongoDB database objects.
9. The client should work only with the `DatabaseFactory` and database object interfaces.
10. The client should not directly instantiate vendor-specific classes.
11. A complete database configuration should obtain all related objects from the same concrete factory.
12. The design should prevent the client from accidentally mixing database objects from different vendor families.
13. Adding a new database vendor should require creating a new concrete factory and its vendor-specific implementations without changing the client code that uses the factory.
14. The client should be able to create and use a complete family of database objects through the selected factory.

## Expected Behavior

For example:

* Selecting the MySQL factory should create a `MySQLConnection`, `MySQLQueryExecutor`, and `MySQLTransactionManager`.
* Selecting the PostgreSQL factory should create a `PostgreSQLConnection`, `PostgreSQLQueryExecutor`, and `PostgreSQLTransactionManager`.
* Selecting the MongoDB factory should create a `MongoDBConnection`, `MongoDBQueryExecutor`, and `MongoDBTransactionManager`.
* The client should interact with all database objects through their common interfaces.
* The client should not contain `new MySQLConnection()`, `new PostgreSQLConnection()`, or `new MongoDBConnection()` calls.
* A complete database configuration should come from the same concrete factory.

## Learning Objective

This exercise demonstrates how the **Abstract Factory Pattern** creates families of related objects while keeping the client independent of concrete implementations.

The abstract factory defines the database object creation contract, while each concrete factory creates a consistent family of vendor-specific database objects.

## Difficulty

Intermediate
