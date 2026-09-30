package com.arcadia.heroes.model;

/** Base abstraction shared by every hero class. */
public abstract class Hero {
    private final String name;
    private final int level;
    private final int health;
    private final int mana;
    private Mission activeMission;

    protected Hero(String name, int level, int health, int mana) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.mana = mana;
    }

    public final String getName() {
        return name;
    }

    public final int getLevel() {
        return level;
    }

    public final int getHealth() {
        return health;
    }

    public final int getMana() {
        return mana;
    }

    public final Mission getActiveMission() {
        return activeMission;
    }

    public final boolean assignMission(Mission mission) {
        if (activeMission != null && activeMission.isInProgress()) {
            return false;
        }
        activeMission = mission;
        return true;
    }

    public final void clearMission() {
        activeMission = null;
    }

    /** First overloaded attack operation: a basic attack without a target. */
    public String attack() {
        return name + " performs a basic attack.";
    }

    /** Second overloaded attack operation: an attack directed at another hero. */
    public String attack(Hero target) {
        return name + " attacks " + target.getName() + ".";
    }

    public abstract String getHeroClass();

    public abstract int calculateStrength();

    public abstract String useSpecialAbility();

    public String getDetails() {
        return "Name: %s | Class: %s | Level: %d | Health: %d | Mana: %d"
                .formatted(name, getHeroClass(), level, health, mana);
    }
}
