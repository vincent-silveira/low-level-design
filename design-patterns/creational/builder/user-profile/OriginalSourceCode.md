# Original Source Code: User Profile Without Design Patterns

## Overview

This implementation creates a `UserProfile` object directly using a constructor containing all of its fields.

It does not use the **Builder Pattern**.

The purpose of this starting implementation is to provide a working user registration module that can later be refactored using the Builder Pattern.

---

## UserProfile.java

```java
public class UserProfile {

    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String address;
    private final String profilePicture;
    private final String dateOfBirth;
    private final boolean newsletterSubscription;

    public UserProfile(
            String name,
            String email,
            String phoneNumber,
            String address,
            String profilePicture,
            String dateOfBirth,
            boolean newsletterSubscription) {

        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profilePicture = profilePicture;
        this.dateOfBirth = dateOfBirth;
        this.newsletterSubscription = newsletterSubscription;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isNewsletterSubscription() {
        return newsletterSubscription;
    }
}
```

---

## UserRegistrationApplication.java

```java
public class UserRegistrationApplication {

    public static void main(String[] args) {

        UserProfile user = new UserProfile(
                "John Doe",
                "john@example.com",
                "9876543210",
                "Mumbai",
                "profile.jpg",
                "15-08-1995",
                true
        );

        System.out.println("User Profile");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone: " + user.getPhoneNumber());
        System.out.println("Address: " + user.getAddress());
        System.out.println("Profile Picture: " + user.getProfilePicture());
        System.out.println("Date of Birth: " + user.getDateOfBirth());
        System.out.println(
                "Newsletter Subscription: "
                        + user.isNewsletterSubscription()
        );
    }
}
```

---

## Sample Output

```text
User Profile
Name: John Doe
Email: john@example.com
Phone: 9876543210
Address: Mumbai
Profile Picture: profile.jpg
Date of Birth: 15-08-1995
Profile Picture: profile.jpg
Newsletter Subscription: true
```

---

## Problems With This Approach

### 1. Constructor With Many Parameters

The client must provide every field when creating a `UserProfile`:

```java
new UserProfile(
        "John Doe",
        "john@example.com",
        "9876543210",
        "Mumbai",
        "profile.jpg",
        "15-08-1995",
        true
);
```

As more fields are added, the constructor becomes increasingly difficult to understand and use.

### 2. Poor Readability

It is not immediately obvious which value corresponds to which field:

```java
new UserProfile(
        "John Doe",
        "john@example.com",
        "9876543210",
        "Mumbai",
        "profile.jpg",
        "15-08-1995",
        true
);
```

The caller must remember the exact parameter order.

### 3. Optional Fields Must Still Be Supplied

Even when a user does not need to provide optional information, the constructor requires values for those fields.

For example:

```java
new UserProfile(
        "John Doe",
        "john@example.com",
        null,
        null,
        null,
        null,
        false
);
```

This makes object creation less readable.

### 4. Difficult to Maintain

If another optional field is added to `UserProfile`, the constructor and every constructor call may need to be modified.

For example, adding:

```text
preferredLanguage
```

would require another constructor parameter.

### 5. Validation Is Not Centralized

The current implementation does not validate required fields such as `name` and `email` before creating the object.

This could allow an invalid profile to be created.

### 6. Construction Logic Is Mixed With Client Code

The client is responsible for knowing how every field is passed to the constructor.

A Builder can move the construction process into a dedicated `UserProfileBuilder`.

---

## Refactoring Goal

Refactor this implementation using the **Builder Pattern**.

The final design should allow the client to construct a `UserProfile` step by step.

The desired usage should look similar to:

```java
UserProfile user = new UserProfileBuilder()
        .setName("John Doe")
        .setEmail("john@example.com")
        .setPhoneNumber("9876543210")
        .setAddress("Mumbai")
        .setProfilePicture("profile.jpg")
        .setDateOfBirth("15-08-1995")
        .setNewsletterSubscription(true)
        .build();
```

The refactored design should:

* Use a `UserProfileBuilder`.
* Keep `UserProfile` immutable.
* Require `name` and `email`.
* Provide sensible defaults for optional fields.
* Validate required fields before creating the object.
* Support fluent method chaining.
* Avoid a constructor with many parameters.
* Keep construction logic separate from the final `UserProfile` object.

Do not add the Builder implementation to this source file. The Builder implementation is the task to be completed.
