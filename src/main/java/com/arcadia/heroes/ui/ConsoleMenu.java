package com.arcadia.heroes.ui;

import com.arcadia.heroes.model.Archer;
import com.arcadia.heroes.model.Hero;
import com.arcadia.heroes.model.Mage;
import com.arcadia.heroes.model.Mission;
import com.arcadia.heroes.model.Warrior;
import com.arcadia.heroes.service.HeroAcademy;

import java.util.Scanner;

/** Console user interface for the academy. */
public final class ConsoleMenu {
    private final HeroAcademy academy;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(HeroAcademy academy) {
        this.academy = academy;
    }

    public void run() {
        int option;
        do {
            printMenu();
            option = readInt("Choose an option: ");
            switch (option) {
                case 1 -> registerHero();
                case 2 -> listHeroes();
                case 3 -> findHero();
                case 4 -> System.out.println(academy.getGeneralStatistics());
                case 5 -> startMission();
                case 6 -> completeMission();
                case 0 -> System.out.println(academy.createKingdomReport());
                default -> System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    private void printMenu() {
        System.out.println("""
                \n=== ARCADIA HEROES ACADEMY ===
                1 - Register hero
                2 - List heroes
                3 - Find hero by name
                4 - Show general statistics
                5 - Start mission
                6 - Complete mission
                0 - Exit and show kingdom report
                """);
    }

    private void registerHero() {
        if (academy.getHeroes().length == HeroAcademy.MAX_HEROES) {
            System.out.println("The academy has reached its maximum of 20 heroes.");
            return;
        }
        String name = readNonBlank("Name: ");
        int level = readPositiveInt("Level: ");
        int health = readPositiveInt("Health: ");
        int mana = readNonNegativeInt("Mana: ");
        int heroType = readInt("Class (1-Warrior, 2-Mage, 3-Archer): ");
        Hero hero = switch (heroType) {
            case 1 -> new Warrior(name, level, health, mana,
                    readPositiveInt("Strength: "), readPositiveInt("Resistance: "), readPositiveInt("Energy: "));
            case 2 -> new Mage(name, level, health, mana,
                    readPositiveInt("Magic power: "), readPositiveInt("Intelligence: "));
            case 3 -> new Archer(name, level, health, mana,
                    readPositiveInt("Precision: "), readPositiveInt("Agility: "), readPositiveInt("Concentration: "));
            default -> null;
        };
        if (hero == null) {
            System.out.println("Invalid hero class.");
        } else if (academy.registerHero(hero)) {
            System.out.println("Hero registered successfully.");
        } else {
            System.out.println("A hero with this name already exists.");
        }
    }

    private void listHeroes() {
        Hero[] heroes = academy.getHeroes();
        if (heroes.length == 0) {
            System.out.println("No registered heroes.");
            return;
        }
        for (Hero hero : heroes) {
            System.out.println(hero.getDetails());
            System.out.println("Strength score: " + hero.calculateStrength());
            System.out.println(hero.useSpecialAbility());
        }
    }

    private void findHero() {
        Hero hero = academy.findHeroByName(readNonBlank("Hero name: "));
        System.out.println(hero == null ? "Hero not found." : hero.getDetails());
    }

    private void startMission() {
        String heroName = readNonBlank("Hero name: ");
        Mission mission = new Mission(readNonBlank("Mission name: "), readNonBlank("Difficulty: "),
                readNonNegativeInt("Gold reward: "));
        System.out.println(academy.assignAndStartMission(heroName, mission));
    }

    private void completeMission() {
        System.out.println(academy.completeMission(readNonBlank("Hero name: ")));
    }

    private int readPositiveInt(String label) {
        int value;
        do {
            value = readInt(label);
            if (value <= 0) {
                System.out.println("Enter a value greater than zero.");
            }
        } while (value <= 0);
        return value;
    }

    private int readNonNegativeInt(String label) {
        int value;
        do {
            value = readInt(label);
            if (value < 0) {
                System.out.println("Enter zero or a positive value.");
            }
        } while (value < 0);
        return value;
    }

    private int readInt(String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Enter a valid whole number.");
            }
        }
    }

    private String readNonBlank(String label) {
        while (true) {
            System.out.print(label);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field is required.");
        }
    }
}
