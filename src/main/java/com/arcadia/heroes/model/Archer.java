package com.arcadia.heroes.model;

/** Herói de longo alcance, com foco em precisão, agilidade e concentração. */
public final class Archer extends Hero {
    private final int precision;
    private final int agility;
    private final int concentration;

    public Archer(String name, int level, int health, int mana, int precision, int agility, int concentration) {
        super(name, level, health, mana);
        this.precision = precision;
        this.agility = agility;
        this.concentration = concentration;
    }

    @Override
    public String getHeroClass() {
        return "Arqueiro";
    }

    @Override
    public int calculateStrength() {
        return getLevel() + precision + agility + concentration;
    }

    @Override
    public String useSpecialAbility() {
        return getName() + " dispara uma Flecha Perfurante.";
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Precisão: %d | Agilidade: %d | Concentração: %d"
                .formatted(precision, agility, concentration);
    }
}
