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
            option = readInt("Escolha uma opção: ");
            switch (option) {
                case 1 -> registerHero();
                case 2 -> listHeroes();
                case 3 -> findHero();
                case 4 -> System.out.println(academy.getGeneralStatistics());
                case 5 -> startMission();
                case 6 -> completeMission();
                case 0 -> System.out.println(academy.createKingdomReport());
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private void printMenu() {
        System.out.println("""
                \n=== ACADEMIA DE HERÓIS DE ARCÁDIA ===
                1 - Cadastrar herói
                2 - Listar heróis
                3 - Buscar herói pelo nome
                4 - Exibir estatísticas gerais
                5 - Iniciar missão
                6 - Concluir missão
                0 - Sair e exibir relatório do reino
                """);
    }

    private void registerHero() {
        if (academy.getHeroes().length == HeroAcademy.MAX_HEROES) {
            System.out.println("A academia atingiu o limite máximo de 20 heróis.");
            return;
        }
        String name = readNonBlank("Nome: ");
        int level = readPositiveInt("Nível: ");
        int health = readPositiveInt("Vida: ");
        int mana = readNonNegativeInt("Mana: ");
        int heroType = readInt("Classe (1-Guerreiro, 2-Mago, 3-Arqueiro): ");
        Hero hero = switch (heroType) {
            case 1 -> new Warrior(name, level, health, mana,
                    readPositiveInt("Força: "), readPositiveInt("Resistência: "), readPositiveInt("Energia: "));
            case 2 -> new Mage(name, level, health, mana,
                    readPositiveInt("Poder mágico: "), readPositiveInt("Inteligência: "));
            case 3 -> new Archer(name, level, health, mana,
                    readPositiveInt("Precisão: "), readPositiveInt("Agilidade: "), readPositiveInt("Concentração: "));
            default -> null;
        };
        if (hero == null) {
            System.out.println("Classe de herói inválida.");
        } else if (academy.registerHero(hero)) {
            System.out.println("Herói cadastrado com sucesso.");
        } else {
            System.out.println("Já existe um herói com este nome.");
        }
    }

    private void listHeroes() {
        Hero[] heroes = academy.getHeroes();
        if (heroes.length == 0) {
            System.out.println("Não há heróis cadastrados.");
            return;
        }
        for (Hero hero : heroes) {
            System.out.println(hero.getDetails());
            System.out.println("Pontuação de força: " + hero.calculateStrength());
            System.out.println(hero.useSpecialAbility());
        }
    }

    private void findHero() {
        Hero hero = academy.findHeroByName(readNonBlank("Nome do herói: "));
        System.out.println(hero == null ? "Herói não encontrado." : hero.getDetails());
    }

    private void startMission() {
        String heroName = readNonBlank("Nome do herói: ");
        Mission mission = new Mission(readNonBlank("Nome da missão: "), readNonBlank("Dificuldade: "),
                readNonNegativeInt("Recompensa em ouro: "));
        System.out.println(academy.assignAndStartMission(heroName, mission));
    }

    private void completeMission() {
        System.out.println(academy.completeMission(readNonBlank("Nome do herói: ")));
    }

    private int readPositiveInt(String label) {
        int value;
        do {
            value = readInt(label);
            if (value <= 0) {
                System.out.println("Informe um valor maior que zero.");
            }
        } while (value <= 0);
        return value;
    }

    private int readNonNegativeInt(String label) {
        int value;
        do {
            value = readInt(label);
            if (value < 0) {
                System.out.println("Informe zero ou um valor positivo.");
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
                System.out.println("Informe um número inteiro válido.");
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
            System.out.println("Este campo é obrigatório.");
        }
    }
}
