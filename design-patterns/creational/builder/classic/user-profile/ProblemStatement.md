# Problem Statement: User Profile Builder

## Scenario

You are developing a user registration module for an application.

The application needs to create user profiles with a combination of required and optional information.

A user profile contains:

### Required Fields

* Name
* Email

### Optional Fields

* Phone Number
* Address
* Profile Picture
* Date of Birth
* Newsletter Subscription

The user profile should be immutable after it has been created.

The application should also avoid constructors with many parameters when creating user profiles.

## Objective

Build a user profile creation module using the **Builder Pattern**.

The Builder should provide a clear and readable way to construct a `UserProfile` object step by step.

The required fields must be provided before the `UserProfile` object can be created, while optional fields should have sensible default values.

For example:

```text
UserProfileBuilder
 ├── name
 ├── email
 ├── phoneNumber
 ├── address
 ├── profilePicture
 ├── dateOfBirth
 └── newsletterSubscription
```

A client should be able to create a profile using a fluent API such as:

```java
UserProfile user = new UserProfileBuilder()
        .setName("John Doe")
        .setEmail("john@example.com")
        .setPhoneNumber("9876543210")
        .setAddress("Mumbai")
        .setNewsletterSubscription(true)
        .build();
```

## Requirements

1. Create a `UserProfile` class containing:

    * `name`
    * `email`
    * `phoneNumber`
    * `address`
    * `profilePicture`
    * `dateOfBirth`
    * `newsletterSubscription`

2. `name` and `email` must be required fields.

3. The remaining fields must be optional.

4. Create a `UserProfileBuilder` class responsible for constructing `UserProfile` objects.

5. The builder should provide methods for setting the optional fields.

6. The builder should provide methods for setting the required fields.

7. The `build()` method should validate that all required fields have been provided before creating the `UserProfile`.

8. If a required field is missing, `build()` should fail with an appropriate exception.

9. Provide sensible default values for optional fields.

10. The `UserProfile` object should be immutable after creation.

11. Fields in `UserProfile` should not be directly modifiable after construction.

12. Avoid using a constructor with a large number of parameters for creating user profiles.

13. The builder methods should support method chaining.

14. The client should be able to create profiles with only the information it needs to provide.

15. Adding another optional field should not require changing the existing client construction approach.

## Expected Behavior

For example:

### Profile With Required Fields Only

```java
UserProfile user = new UserProfileBuilder()
        .setName("John Doe")
        .setEmail("john@example.com")
        .build();
```

This should create a valid profile using the default values for all optional fields.

### Profile With Optional Fields

```java
UserProfile user = new UserProfileBuilder()
        .setName("Jane Doe")
        .setEmail("jane@example.com")
        .setPhoneNumber("9876543210")
        .setAddress("Mumbai")
        .setNewsletterSubscription(true)
        .build();
```

This should create a profile containing the supplied optional information.

### Missing Required Field

```java
UserProfile user = new UserProfileBuilder()
        .setName("John Doe")
        .build();
```

This should fail because the required `email` field has not been provided.

Similarly:

```java
UserProfile user = new UserProfileBuilder()
        .setEmail("john@example.com")
        .build();
```

should fail because the required `name` field has not been provided.

## Learning Objective

This exercise demonstrates how the **Builder Pattern** separates the construction of a complex object from its final representation.

The builder allows an object with multiple optional fields to be created in a readable and controlled manner without requiring a constructor with many parameters.

The exercise also demonstrates:

* Fluent object construction
* Validation before object creation
* Sensible defaults for optional fields
* Immutable objects
* Separation of construction logic from the final object

## Difficulty

Beginner
