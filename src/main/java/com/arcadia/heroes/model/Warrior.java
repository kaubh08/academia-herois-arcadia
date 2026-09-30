package com.arcadia.heroes.model;

/** A durable melee hero. */
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
        return "Warrior";
    }

    @Override
    public int calculateStrength() {
        return getLevel() + strength + resistance + energy;
    }

    @Override
    public String useSpecialAbility() {
        return getName() + " uses Shield Break.";
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Strength: %d | Resistance: %d | Energy: %d"
                .formatted(strength, resistance, energy);
    }
}
