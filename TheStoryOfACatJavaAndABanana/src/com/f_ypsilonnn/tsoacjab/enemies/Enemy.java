package com.f_ypsilonnn.tsoacjab.enemies;

import com.f_ypsilonnn.tsoacjab.Adventure;

public abstract class Enemy {
    protected int level;
    protected int maxHealth;
    protected int health;
    protected int healthRegen;
    protected int mobConstant;
    protected int damage;
    protected int experienceYield;

    protected boolean alive;

    protected String displayName = "";

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealthRegen(int healthRegen) {
        this.healthRegen = healthRegen;
    }

    public int getHealthRegen() {
        return healthRegen;
    }

    public void setMobConstant(int mobConstant) {
        this.mobConstant = mobConstant;
    }

    public int getMobConstant() {
        return mobConstant;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setExperienceYield(int experienceYield) {
        this.experienceYield = experienceYield;
    }

    public int getExperienceYield() {
        return experienceYield;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int levelCalculation(int playerLevel) {
        int min = -2;
        int max = 2;
        int range = max - min + 1;
        int level;
        playerLevel = Adventure.p1.getPlayerLevel();
        level = playerLevel + (int)(Math.random() * range) + min;
        if (level < 1) {
            level = 1;
        }
        return level;
    }

    public int maxHealthCalculation(int enemyLevel) {
        return mobConstant + (int)(Math.pow(enemyLevel , 1.5));
    }

    public int healthRegenCalculation() {
        return maxHealth / 10;
    }

    public int damageCalculation(int enemyLevel) {
        return (int)(mobConstant / 3) + (int)(Math.pow(enemyLevel * 2, 0.5));
    }

    public int experienceYieldCalculation(int enemyLevel) {
        return (int)(mobConstant / 3 * (enemyLevel + 1) / 2);
    }
}
