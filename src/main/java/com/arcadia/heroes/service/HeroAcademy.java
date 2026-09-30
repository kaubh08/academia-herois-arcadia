package com.arcadia.heroes.service;

import com.arcadia.heroes.model.Archer;
import com.arcadia.heroes.model.Hero;
import com.arcadia.heroes.model.Mage;
import com.arcadia.heroes.model.Mission;
import com.arcadia.heroes.model.Warrior;

/** Centraliza as regras de cadastro de heróis, missões e cálculos do relatório. */
public final class HeroAcademy {
    public static final int MAX_HEROES = 20;

    // Vetor de tamanho fixo exigido pela atividade: armazena no máximo 20 heróis.
    private final Hero[] heroes = new Hero[MAX_HEROES];
    private int heroCount;
    private int completedMissions;

    public boolean registerHero(Hero hero) {
        if (heroCount == MAX_HEROES || findHeroByName(hero.getName()) != null) {
            return false;
        }
        heroes[heroCount++] = hero;
        return true;
    }

    public Hero[] getHeroes() {
        Hero[] registeredHeroes = new Hero[heroCount];
        System.arraycopy(heroes, 0, registeredHeroes, 0, heroCount);
        return registeredHeroes;
    }

    public Hero findHeroByName(String name) {
        for (int index = 0; index < heroCount; index++) {
            if (heroes[index].getName().equalsIgnoreCase(name.trim())) {
                return heroes[index];
            }
        }
        return null;
    }

    public String assignAndStartMission(String heroName, Mission mission) {
        Hero hero = findHeroByName(heroName);
        if (hero == null) {
            return "Herói não encontrado.";
        }
        if (!hero.assignMission(mission)) {
            return "Este herói já possui uma missão em andamento.";
        }
        return hero.getName() + ": " + mission.startMission();
    }

    public String completeMission(String heroName) {
        Hero hero = findHeroByName(heroName);
        if (hero == null || hero.getActiveMission() == null) {
            return "Herói ou missão ativa não encontrado.";
        }
        Mission mission = hero.getActiveMission();
        String result = mission.completeMission();
        if (mission.isCompleted()) {
            completedMissions++;
            hero.clearMission();
        }
        return result;
    }

    /** Monta o relatório final usando o vetor polimórfico de heróis. */
    public String createKingdomReport() {
        int warriors = 0;
        int mages = 0;
        int archers = 0;
        int totalLevel = 0;
        Hero strongestHero = null;

        for (Hero hero : getHeroes()) {
            totalLevel += hero.getLevel();
            if (hero instanceof Warrior) {
                warriors++;
            } else if (hero instanceof Mage) {
                mages++;
            } else if (hero instanceof Archer) {
                archers++;
            }
            if (strongestHero == null || hero.calculateStrength() > strongestHero.calculateStrength()) {
                strongestHero = hero;
            }
        }

        double averageLevel = heroCount == 0 ? 0 : (double) totalLevel / heroCount;
        String strongestName = strongestHero == null ? "Nenhum" : strongestHero.getName();
        return """
                ========= RELATÓRIO DO REINO =========
                Total de Heróis: %d

                Guerreiros: %d
                Magos: %d
                Arqueiros: %d

                Média de nível: %.2f
                Herói mais forte: %s
                Missões concluídas: %d
                """.formatted(heroCount, warriors, mages, archers, averageLevel, strongestName, completedMissions);
    }

    public String getGeneralStatistics() {
        return "Heróis cadastrados: " + heroCount + "/" + MAX_HEROES + System.lineSeparator() + createKingdomReport();
    }
}
