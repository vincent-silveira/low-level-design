# Problem Statement: Cross-Platform UI Toolkit

## Scenario

You are developing a desktop application that supports multiple operating systems.

The application needs to provide a consistent set of UI components for:

- Windows
- macOS
- Linux

Each platform provides its own implementation of the following UI components:

- Button
- Checkbox
- TextField

The application should be able to create a complete set of UI components for one platform without the client needing to know the concrete implementation classes.

## Objective

Build a cross-platform UI toolkit using the **Abstract Factory Pattern**.

The abstract factory should define methods for creating a family of related UI components. Each concrete platform factory should create the components belonging to its platform.

For example:

```text
WindowsUIFactory
 ├── WindowsButton
 ├── WindowsCheckbox
 └── WindowsTextField
```

## Requirements

1. Create a common interface for `Button`.
2. Create a common interface for `Checkbox`.
3. Create a common interface for `TextField`.
4. Create separate implementations of each component for Windows, macOS, and Linux.
5. Create a common `UIFactory` interface that declares factory methods for creating:
   - `Button`
   - `Checkbox`
   - `TextField`
6. Create a `WindowsUIFactory` that creates Windows UI components.
7. Create a `MacOSUIFactory` that creates macOS UI components.
8. Create a `LinuxUIFactory` that creates Linux UI components.
9. The client should work only with the `UIFactory` and component interfaces.
10. The client should not directly instantiate concrete platform-specific components.
11. Components from different platforms should not be mixed within the same UI configuration.
12. Adding a new platform should require creating a new concrete factory and its component implementations without changing the client code.
13. The client should be able to create and use a complete family of components through the selected factory.

## Expected Behavior

For example:

* Selecting the Windows factory should create a `WindowsButton`, `WindowsCheckbox`, and `WindowsTextField`.
* Selecting the macOS factory should create a `MacOSButton`, `MacOSCheckbox`, and `MacOSTextField`.
* Selecting the Linux factory should create a `LinuxButton`, `LinuxCheckbox`, and `LinuxTextField`.
* The client should interact with all components through their common interfaces.
* The client should not contain `new WindowsButton()`, `new MacOSButton()`, or `new LinuxButton()` calls.
* A complete UI component family should come from the same concrete factory.

## Learning Objective

This exercise demonstrates how the **Abstract Factory Pattern** creates families of related objects while keeping the client independent of concrete implementations.

The abstract factory defines the component creation contract, while each concrete factory creates a consistent family of platform-specific UI components.

## Difficulty

Beginner
