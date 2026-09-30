package com.arcadia.heroes.model;

/** Herói de combate corpo a corpo, com foco em força e resistência. */
public final class Warrior extends Hero {
    private final int strength;
    private final int resistance;
    private final int energy;

    public Warrior(String name, int level, int health, int mana, int strength, int resistance, int energy) {
        super(name, level, health, mana);
        this.strength = strength;
        this.resistance = resistance;
        this.energy = energy;
    }

    @Override
    public String getHeroClass() {
        return "Guerreiro";
    }

    @Override
    public int calculateStrength() {
        return getLevel() + strength + resistance + energy;
    }

    @Override
    public String useSpecialAbility() {
        return getName() + " usa Quebra de Escudo.";
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Força: %d | Resistência: %d | Energia: %d"
                .formatted(strength, resistance, energy);
    }
}
