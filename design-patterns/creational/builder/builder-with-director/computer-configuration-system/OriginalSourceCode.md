# Original Source Code: Computer Configuration System Without Design Patterns

## Overview

This implementation creates `Computer` objects directly using constructors and manually assembled configuration logic.

It does **not** use the Builder Pattern or a Director.

The purpose of this starting implementation is to provide a working computer configuration system that can later be refactored using the **Builder Pattern with a Director**.

---

## Computer.java

```java
public class Computer {

    private final String processor;
    private final String ram;
    private final String storage;
    private final String graphicsCard;
    private final String operatingSystem;
    private final boolean wifiSupport;

    public Computer(
            String processor,
            String ram,
            String storage,
            String graphicsCard,
            String operatingSystem,
            boolean wifiSupport) {

        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
        this.operatingSystem = operatingSystem;
        this.wifiSupport = wifiSupport;
    }

    public String getProcessor() {
        return processor;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public boolean isWifiSupport() {
        return wifiSupport;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", wifiSupport=" + wifiSupport +
                '}';
    }
}
```

---

## ComputerConfigurationApplication.java

```java
public class ComputerConfigurationApplication {

    public static void main(String[] args) {

        Computer gamingComputer = new Computer(
                "Intel Core i9",
                "32GB",
                "1TB SSD",
                "NVIDIA RTX 4080",
                "Windows 11",
                true
        );

        Computer officeComputer = new Computer(
                "Intel Core i5",
                "16GB",
                "512GB SSD",
                "Integrated Graphics",
                "Windows 11",
                true
        );

        Computer customComputer = new Computer(
                "AMD Ryzen 7",
                "64GB",
                "2TB SSD",
                "AMD Radeon RX 7900",
                "Ubuntu Linux",
                false
        );

        System.out.println("Gaming Computer");
        printComputerDetails(gamingComputer);

        System.out.println();

        System.out.println("Office Computer");
        printComputerDetails(officeComputer);

        System.out.println();

        System.out.println("Custom Computer");
        printComputerDetails(customComputer);
    }

    private static void printComputerDetails(Computer computer) {

        System.out.println("Processor: "
                + computer.getProcessor());

        System.out.println("RAM: "
                + computer.getRam());

        System.out.println("Storage: "
                + computer.getStorage());

        System.out.println("Graphics Card: "
                + computer.getGraphicsCard());

        System.out.println("Operating System: "
                + computer.getOperatingSystem());

        System.out.println("Wi-Fi Support: "
                + computer.isWifiSupport());
    }
}
```

---

## Sample Output

```text
Gaming Computer
Processor: Intel Core i9
RAM: 32GB
Storage: 1TB SSD
Graphics Card: NVIDIA RTX 4080
Operating System: Windows 11
Wi-Fi Support: true

Office Computer
Processor: Intel Core i5
RAM: 16GB
Storage: 512GB SSD
Graphics Card: Integrated Graphics
Operating System: Windows 11
Wi-Fi Support: true

Custom Computer
Processor: AMD Ryzen 7
RAM: 64GB
Storage: 2TB SSD
Graphics Card: AMD Radeon RX 7900
Operating System: Ubuntu Linux
Wi-Fi Support: false
```

---

## Problems With This Approach

### 1. Constructor With Multiple Parameters

The `Computer` constructor requires every configuration value:

```java
new Computer(
        "Intel Core i9",
        "32GB",
        "1TB SSD",
        "NVIDIA RTX 4080",
        "Windows 11",
        true
);
```

As more computer components are added, the constructor can become difficult to read and maintain.

### 2. Poor Readability

The meaning of each argument is not immediately obvious from the constructor call.

For example:

```java
"Intel Core i9",
"32GB",
"1TB SSD",
"NVIDIA RTX 4080",
"Windows 11",
true
```

The client must know the exact parameter order.

### 3. Construction Logic Is Located in the Client

The client is responsible for knowing every component required for each configuration.

If the manufacturer changes the predefined gaming or office configuration, the client code must be updated.

### 4. Predefined Configurations Are Not Encapsulated

The steps for creating a gaming computer and an office computer are directly written in the client.

This makes it difficult to reuse the same predefined construction process in multiple places.

### 5. Difficult to Customize and Maintain

The client must manually provide every configuration value through the constructor, even when it only wants to change a few components.

Adding new configuration fields would require updating the constructor and its call sites.

### 6. No Separation Between Construction and Representation

The `Computer` class is created directly from the client, and the client is responsible for assembling all configuration values.

A Builder can separate the construction process from the final `Computer` object, while a Director can control predefined construction sequences.

---

## Refactoring Goal

Refactor this implementation using the **Builder Pattern with a Director**.

The refactored design should:

- Introduce one reusable `ComputerBuilder` class for configuring a `Computer`.
- Introduce one `ComputerDirector` that contains predefined construction methods for gaming and office computers and creates a fresh `ComputerBuilder` internally for each recipe.
- Allow the `ComputerBuilder` to be used directly for custom configurations.
- Keep the final `Computer` object separate from the construction process.
- Move predefined construction sequences out of the client.
- Avoid creating separate builder implementations when gaming and office computers use the same construction operations.
- Avoid unnecessary `GamingPC` and `OfficePC` convenience classes.
- Preserve the ability to display all computer configuration details.

The intended structure is:

```text
Computer
ComputerBuilder
ComputerDirector
ComputerConfigurationApplication
```

The application should use the Director directly for predefined gaming and office computers, and use the Builder directly for custom computers.

Do not add the Builder or Director implementation to this source file. The Builder and Director implementation is the task to be completed.
