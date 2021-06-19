package com.f_ypsilonnn.tsoacjab.enemies;

public class Boss1Ogre extends Enemy {
    public Boss1Ogre() {
        displayName = "Ancient Ogre";
        level = 3;
        mobConstant = 15;
        maxHealth = 50;
    }
    @Override
    public int experienceYieldCalculation(int enemyLevel) {
        return 50;
    }
}
