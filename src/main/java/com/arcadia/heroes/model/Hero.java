package com.arcadia.heroes.model;

/** Abstração-base que reúne os atributos e comportamentos comuns a todos os heróis. */
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

    /** Primeira sobrecarga de ataque: realiza um ataque básico sem alvo definido. */
    public String attack() {
        return name + " realiza um ataque básico.";
    }

    /** Segunda sobrecarga de ataque: direciona o ataque para outro herói. */
    public String attack(Hero target) {
        return name + " ataca " + target.getName() + ".";
    }

    public abstract String getHeroClass();

    public abstract int calculateStrength();

    public abstract String useSpecialAbility();

    public String getDetails() {
        return "Nome: %s | Classe: %s | Nível: %d | Vida: %d | Mana: %d"
                .formatted(name, getHeroClass(), level, health, mana);
    }
}
