# Original Source Code: Cross-Platform UI Toolkit Without Design Patterns

## Overview

This implementation creates platform-specific UI component objects directly in the client code.

It does not use the **Abstract Factory Pattern** or a common abstract UI factory.

---

## Button.java

```java
public interface Button {

    void render();
}
```

---

## Checkbox.java

```java
public interface Checkbox {

    void render();
}
```

---

## TextField.java

```java
public interface TextField {

    void render();
}
```

---

## WindowsButton.java

```java
public class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}
```

---

## WindowsCheckbox.java

```java
public class WindowsCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}
```

---

## WindowsTextField.java

```java
public class WindowsTextField implements TextField {

    @Override
    public void render() {
        System.out.println("Rendering Windows TextField");
    }
}
```

---

## MacOSButton.java

```java
public class MacOSButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering macOS Button");
    }
}
```

---

## MacOSCheckbox.java

```java
public class MacOSCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Rendering macOS Checkbox");
    }
}
```

---

## MacOSTextField.java

```java
public class MacOSTextField implements TextField {

    @Override
    public void render() {
        System.out.println("Rendering macOS TextField");
    }
}
```

---

## LinuxButton.java

```java
public class LinuxButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering Linux Button");
    }
}
```

---

## LinuxCheckbox.java

```java
public class LinuxCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Rendering Linux Checkbox");
    }
}
```

---

## LinuxTextField.java

```java
public class LinuxTextField implements TextField {

    @Override
    public void render() {
        System.out.println("Rendering Linux TextField");
    }
}
```

---

## UIApplication.java

```java
public class UIApplication {

    public static void main(String[] args) {

        String platform = "WINDOWS";

        Button button;
        Checkbox checkbox;
        TextField textField;

        if (platform.equalsIgnoreCase("WINDOWS")) {
            button = new WindowsButton();
            checkbox = new WindowsCheckbox();
            textField = new WindowsTextField();

        } else if (platform.equalsIgnoreCase("MACOS")) {
            button = new MacOSButton();
            checkbox = new MacOSCheckbox();
            textField = new MacOSTextField();

        } else if (platform.equalsIgnoreCase("LINUX")) {
            button = new LinuxButton();
            checkbox = new LinuxCheckbox();
            textField = new LinuxTextField();

        } else {
            throw new IllegalArgumentException(
                "Invalid platform: " + platform
            );
        }

        button.render();
        checkbox.render();
        textField.render();
    }
}
```

---

## Sample Output

```text
Rendering Windows Button
Rendering Windows Checkbox
Rendering Windows TextField
```

---

## Problems With This Approach

### 1. Direct Object Creation

The client directly creates concrete platform-specific components:

```java
new WindowsButton();
new WindowsCheckbox();
new WindowsTextField();
```

This creates tight coupling between the client and platform-specific implementations.

### 2. Conditional Logic in Client

The client contains multiple `if-else` statements to decide which family of UI components to create.

As more platforms are added, this logic becomes increasingly difficult to maintain.

### 3. Components Can Be Mixed

Because the client creates each component independently, it could accidentally create components from different platforms.

For example:

```java
button = new WindowsButton();
checkbox = new LinuxCheckbox();
textField = new WindowsTextField();
```

This violates the requirement that a UI should use a consistent family of platform-specific components.

### 4. Difficult to Extend

Adding a new platform requires modifying the client class.

For example, adding a new platform would require another conditional branch and direct object creation calls.

### 5. Client Depends on Concrete Implementations

The client knows the names and construction details of every platform-specific component.

This makes the application harder to maintain and reduces the benefit of programming against abstractions.

---

## Conclusion

This implementation works, but the client is responsible for selecting the platform and creating every concrete UI component.

The **Abstract Factory Pattern** can improve this design by introducing a common factory interface for creating related UI components.

Each concrete platform factory can then create a complete, consistent family of components while keeping the client independent of concrete platform implementations.
