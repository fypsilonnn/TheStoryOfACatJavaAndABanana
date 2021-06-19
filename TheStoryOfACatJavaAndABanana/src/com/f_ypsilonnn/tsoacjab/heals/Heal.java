package com.f_ypsilonnn.tsoacjab.heals;

public abstract class Heal {
    int healthRestored;

    String healDisplayName = "";

    public void setHealthRestored(int healthRestored) {
        this.healthRestored = healthRestored;
    }

    public int getHealthRestored() {
        return healthRestored;
    }

    public void setHealDisplayName(String healDisplayName) {
        this.healDisplayName = healDisplayName;
    }

    public String getHealDisplayName() {
        return healDisplayName;
    }
}
