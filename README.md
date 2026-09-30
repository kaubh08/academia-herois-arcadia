# Arcadia Heroes Academy

Console application developed in Java 17 and Maven to manage heroes, missions, and the kingdom report.

## Requirements

- JDK 17 or newer
- Maven 3.9 or newer

## Run in IntelliJ IDEA

1. Select **File > Open** and choose this folder (the one containing `pom.xml`).
2. Trust the project and let IntelliJ import Maven dependencies.
3. Run `com.arcadia.heroes.Application`.

## Run in a terminal

```bash
mvn compile
java -cp target/classes com.arcadia.heroes.Application
```

## Design notes

- `Hero[]` is a fixed array with a capacity of 20, as required.
- `Hero` is abstract and `Warrior`, `Mage`, and `Archer` extend it.
- Polymorphism is used to display details, calculate strength, and use abilities.
- `attack()` is overloaded and subclass ability methods are overridden.
