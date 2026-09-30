package com.arcadia.heroes.model;

/** Represents a mission a hero can start and complete. */
public final class Mission {
    private final String name;
    private final String difficulty;
    private final int goldReward;
    private boolean inProgress;
    private boolean completed;

    public Mission(String name, String difficulty, int goldReward) {
        this.name = name;
        this.difficulty = difficulty;
        this.goldReward = goldReward;
    }

    public String getName() {
        return name;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String startMission() {
        if (completed) {
            return "Esta missão já foi concluída.";
        }
        inProgress = true;
        return "Missão iniciada: " + name + " (" + difficulty + ").";
    }

    public String completeMission() {
        if (!inProgress) {
            return "Inicie a missão antes de concluí-la.";
        }
        inProgress = false;
        completed = true;
        return "Missão concluída: " + name + ". Recompensa: " + goldReward + " ouros.";
    }
}
