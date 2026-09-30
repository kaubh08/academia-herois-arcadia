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
            return "This mission was already completed.";
        }
        inProgress = true;
        return "Mission started: " + name + " (" + difficulty + ").";
    }

    public String completeMission() {
        if (!inProgress) {
            return "Start the mission before completing it.";
        }
        inProgress = false;
        completed = true;
        return "Mission completed: " + name + ". Reward: " + goldReward + " gold.";
    }
}
