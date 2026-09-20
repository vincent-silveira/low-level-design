# Problem Statement: Computer Configuration System

## Scenario

You are building a computer configuration system for a computer manufacturer.

A computer can contain several configurable components:

- Processor
- RAM
- Storage
- Graphics Card
- Operating System
- Wi-Fi Support

The system must support both predefined computer configurations and fully customized computers.

The manufacturer offers predefined configurations such as:

- Gaming Computer
- Office Computer

The system should avoid duplicating builder implementations when both configurations use the same construction operations.

---

## Objective

Refactor the computer construction process using the **Builder Design Pattern with a Director**.

The design should:

- Use one reusable `ComputerBuilder` class to configure a `Computer`.
- Use one `ComputerDirector` to control predefined construction sequences.
- Allow clients to use the builder directly for customized computers.
- Keep the final `Computer` object separate from the construction process.
- Move predefined construction recipes out of the application client.

The Director should define the predefined recipes, while the builder should perform the individual configuration operations.

---

## Required Classes

### 1. `Computer`

Represents the final product.

It should contain:

- Processor
- RAM
- Storage
- Graphics Card
- Operating System
- Wi-Fi Support

Provide appropriate getters and preserve the ability to print the computer's configuration details.

### 2. `ComputerBuilder`

Create one reusable concrete builder class.

The builder should:

- Store the configuration values required to create a `Computer`.
- Provide fluent setter methods for each component.
- Return `this` from setter methods to support method chaining.
- Provide a `build()` method that returns a completed `Computer`.

Required operations:

```java
setProcessor(String processor)
setRam(String ram)
setStorage(String storage)
setGraphicsCard(String graphicsCard)
setOperatingSystem(String operatingSystem)
setWifiSupport(boolean wifiSupport)
build()
```

The builder must be usable directly by the client for custom configurations.

Do not create separate `GamingComputerBuilder` and `OfficeComputerBuilder` classes. Both predefined configurations use the same builder operations and implementation.

### 3. `ComputerDirector`

Create one Director class that contains predefined construction methods for:

- Gaming Computer
- Office Computer

The Director should:

1. Receive a `ComputerBuilder`.
2. Call the builder's configuration methods in a defined order.
3. Apply the predefined component values for each configuration.
4. Call `build()` and return the completed `Computer`.

The Director should provide methods similar to:

```java
buildGamingComputer()
buildOfficeComputer()
```

Each method should create a fresh `ComputerBuilder` internally, configure it using the predefined recipe, call `build()`, and return the completed `Computer`.

The exact method signatures may vary, but the Director must clearly control the predefined construction sequences.

The Director should not create separate Director classes for gaming and office computers.

### 4. `ComputerConfigurationApplication`

The application should demonstrate all of the following:

#### Predefined Gaming Computer

```java
ComputerDirector director = new ComputerDirector();

Computer gamingComputer =
        director.buildGamingComputer();
```

#### Predefined Office Computer

```java
Computer officeComputer =
        director.buildOfficeComputer();
```

#### Custom Computer

```java
Computer customComputer = new ComputerBuilder()
        .setProcessor("AMD Ryzen 7")
        .setRam("32GB")
        .setStorage("2TB SSD")
        .setGraphicsCard("NVIDIA RTX 4070")
        .setOperatingSystem("Linux")
        .setWifiSupport(true)
        .build();
```

The application should print the configuration details of all three computers.

---

## Design Constraints

1. Use exactly one reusable concrete `ComputerBuilder`.
2. Use exactly one `ComputerDirector`.
3. Do not create `GamingComputerBuilder` or `OfficeComputerBuilder`.
4. Do not create separate Director classes for gaming and office computers.
5. Do not create `GamingPC` or `OfficePC` convenience classes.
6. The Director must create a fresh builder for each predefined recipe.
7. The Director must contain the predefined construction sequences.
8. The builder must remain usable directly for custom configurations.
9. The final `Computer` object must be created through `build()`.

---

## Learning Objectives

By completing this exercise, you should understand:

- How the Builder Pattern separates object construction from representation.
- How fluent methods support readable configuration.
- How a Director encapsulates predefined construction sequences.
- Why multiple predefined products can reuse one builder implementation.
- How clients can choose between predefined recipes and custom construction.
- How to avoid unnecessary classes and duplicated construction logic.

---

## Deliverables

Provide the following Java classes:

```text
Computer.java
ComputerBuilder.java
ComputerDirector.java
ComputerConfigurationApplication.java
```

Do not add the Builder or Director implementation to this problem statement. Those implementations are the task to be completed.
