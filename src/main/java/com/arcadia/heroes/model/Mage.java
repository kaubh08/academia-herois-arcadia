package com.arcadia.heroes.model;

/** A hero specialized in magic. */
public final class Mage extends Hero {
    private final int magicPower;
    private final int intelligence;

    public Mage(String name, int level, int health, int mana, int magicPower, int intelligence) {
        super(name, level, health, mana);
        this.magicPower = magicPower;
        this.intelligence = intelligence;
    }

    @Override
    public String getHeroClass() {
        return "Mago";
    }

    @Override
    public int calculateStrength() {
        return getLevel() + getMana() + magicPower + intelligence;
    }

    @Override
    public String useSpecialAbility() {
        return getName() + " lança Tempestade Arcana.";
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Poder Mágico: %d | Inteligência: %d"
                .formatted(magicPower, intelligence);
    }
}
