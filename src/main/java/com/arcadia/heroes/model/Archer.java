package com.arcadia.heroes.model;

/** A ranged hero with accurate attacks. */
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
        return "Archer";
    }

    @Override
    public int calculateStrength() {
        return getLevel() + precision + agility + concentration;
    }

    @Override
    public String useSpecialAbility() {
        return getName() + " fires a Piercing Arrow.";
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Precision: %d | Agility: %d | Concentration: %d"
                .formatted(precision, agility, concentration);
    }
}
