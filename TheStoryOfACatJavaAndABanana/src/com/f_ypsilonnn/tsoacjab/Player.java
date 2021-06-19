package com.f_ypsilonnn.tsoacjab;

import com.f_ypsilonnn.tsoacjab.enemies.Enemy;
import com.f_ypsilonnn.tsoacjab.exceptions.NotANumberException;
import com.f_ypsilonnn.tsoacjab.heals.Heal;
import com.f_ypsilonnn.tsoacjab.sidequests.SheepProtection1;
import com.f_ypsilonnn.tsoacjab.sidequests.Sidequest;
import com.f_ypsilonnn.tsoacjab.weapons.Weapon;
import javafx.geometry.Side;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class Player {

    protected int playerLevel;
    protected int epToNextLevel;
    protected int currentEP;
    protected int playerMaxHealth;
    protected int playerHealth;
    protected int playerMaxMana;
    protected int playerMana;
    protected int playerBaseDamage;

    ArrayList<Weapon> meleeWeapons = new ArrayList<>();
    HashMap<Weapon, Integer> meleeWeaponsNumber = new HashMap<>();
    HashMap<Weapon, String> meleeWeaponsName = new HashMap<>();
    HashMap<String, Weapon> meleeWeaponsNameToWeapon = new HashMap<>();
    HashMap<Integer, Weapon> meleeWeaponsNumberToWeapon = new HashMap<>();

    ArrayList<Weapon> magicWeapons = new ArrayList<>();
    HashMap<Weapon, Integer> magicWeaponsNumber = new HashMap<>();
    HashMap<Weapon, String> magicWeaponsName = new HashMap<>();
    HashMap<String, Weapon> magicWeaponsNameToWeapon = new HashMap<>();
    HashMap<Integer, Weapon> magicWeaponsNumberToWeapon = new HashMap<>();

    ArrayList<Heal> heals = new ArrayList<>();
    HashMap<Heal, Integer> healNumber = new HashMap<>();
    HashMap<Heal, String> healName = new HashMap<>();
    HashMap<String, Heal> healNameToHeal = new HashMap<>();
    HashMap<Integer, Heal> healNumberToHeal = new HashMap<>();

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setEpToNextLevel(int epToNextLevel) {
        this.epToNextLevel = epToNextLevel;
    }

    public int getEpToNextLevel() {
        return epToNextLevel;
    }

    public void setCurrentEP(int currentEP) {
        this.currentEP = currentEP;
    }

    public int getCurrentEP() {
        return currentEP;
    }

    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }

    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerMaxMana(int playerMaxMana) {
        this.playerMaxMana = playerMaxMana;
    }

    public int getPlayerMaxMana() {
        return playerMaxMana;
    }

    public void setPlayerMana(int playerMana) {
        this.playerMana = playerMana;
    }

    public int getPlayerMana() {
        return playerMana;
    }

    public void setPlayerBaseDamage(int playerBaseDamage) {
        this.playerBaseDamage = playerBaseDamage;
    }

    public int getPlayerBaseDamage() {
        return playerBaseDamage;
    }

    public void addMeleeWeaponToInv(Weapon weapon, String weaponName) {
        meleeWeapons.add(weapon);
        meleeWeaponsNumber.put(weapon, meleeWeapons.size());
        meleeWeaponsName.put(weapon, weaponName);
        meleeWeaponsNameToWeapon.put(weaponName, weapon);
        meleeWeaponsNumberToWeapon.put(meleeWeapons.size(), weapon);
    }

    public void removeMeleeWeaponFromInv(Weapon weapon, String weaponName) {
        meleeWeapons.remove(weapon);
        meleeWeaponsNumber.remove(weapon, meleeWeaponsNumber.get(weapon));
        meleeWeaponsName.remove(weapon, weaponName);
        meleeWeaponsNameToWeapon.remove(weaponName, weapon);
        meleeWeaponsNumberToWeapon.remove(meleeWeaponsNumber.get(weapon), weapon);
    }

    public void addMagicWeaponToInv(Weapon weapon, String weaponName) {
        magicWeapons.add(weapon);
        magicWeaponsNumber.put(weapon, magicWeapons.size());
        magicWeaponsName.put(weapon, weaponName);
        magicWeaponsNameToWeapon.put(weaponName, weapon);
        magicWeaponsNumberToWeapon.put(magicWeapons.size(), weapon);
    }

    public void addHealToInv(Heal heal, String healDisplayName) {
        heals.add(heal);
        healNumber.put(heal, heals.size());
        healName.put(heal, healDisplayName);
        healNameToHeal.put(healDisplayName, heal);
        healNumberToHeal.put(heals.size(), heal);
    }

    public void healPlayerOutOfFight(int healedHP) {
        setPlayerHealth(getPlayerHealth() + healedHP);
        if (getPlayerHealth() > getPlayerMaxHealth()) {
            setPlayerHealth(getPlayerMaxHealth());
        }
    }

    public int epToNextLevelCalculation() {
        return (int)(Math.pow(getEpToNextLevel(), 1.1));
    }

    public void listMeleeWeaponsInInv() {
        for (int i = 0; i < meleeWeapons.size(); i++) {
            System.out.println(meleeWeaponsNumber.get(meleeWeapons.get(i)) + " " + meleeWeaponsName.get(meleeWeapons.get(i)));
        }
    }

    public void listMagicWeaponsInInv() {
        for (int i = 0; i < magicWeapons.size(); i++) {
            System.out.println(magicWeaponsNumber.get(meleeWeapons.get(i)) + " " + magicWeaponsName.get(magicWeapons.get(i)));
        }
    }

    public void listHealsInInv() {
        for (int i = 0; i < heals.size(); i++) {
            System.out.println(healNumber.get(heals.get(i)) + " " + healName.get(heals.get(i)));
        }
    }

    public String playerInput() {
        BufferedReader actionInput = new BufferedReader(new InputStreamReader(System.in));
        try {
            return actionInput.readLine().toUpperCase(Locale.ROOT);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void playerLevelCalculation(Enemy enemy, int thisEnemyLevel) {
        setCurrentEP(getCurrentEP() + enemy.experienceYieldCalculation(thisEnemyLevel));
        if(getCurrentEP() >= getEpToNextLevel()) {
            levelingUp();
        } else {
            System.out.println("You have " + getCurrentEP() + " EP of " + getEpToNextLevel() + " EP needed to level up.");
        }
    }

    public void levelingUp() {
        while (getCurrentEP() > getEpToNextLevel()) {
            setPlayerLevel(getPlayerLevel() + 1);
            setCurrentEP(getCurrentEP() - getEpToNextLevel());
            setEpToNextLevel(epToNextLevelCalculation());
            System.out.println("You reached level " + getPlayerLevel());
            System.out.println("You gained 1 SP (SKILL POINT), you can use this SP to upgrade either your BASE DAMAGE (BASE DMG), MAXIMUM HEALTH (MAX HEALTH) or MAXIMUM MANA (MAX MANA).");
            System.out.println("What do you want to upgrade?");
            String choice;
            choice = choiceControlOption("BASE DMG", "MAX HEALTH", "MAX HEALTH");
            switch (choice) {
                case "BASE DMG":
                    setPlayerBaseDamage(getPlayerBaseDamage() + getPlayerLevel());
                    System.out.println("Successfully leveled up BASE DAMAGE, your BASE DAMAGE is now: " + getPlayerBaseDamage());
                    break;
                case "MAX HEALTH":
                    setPlayerMaxHealth(getPlayerMaxHealth() + (int) ((getPlayerLevel() + 5) / 2));
                    break;
                case "MAX MANA":
                    setPlayerMaxMana(getPlayerMaxMana() + (int) (getPlayerLevel() + 2 / 3));
                    break;
            }
            setPlayerHealth(getPlayerMaxHealth());
            setPlayerMana(getPlayerMaxMana());
            System.out.println("You leveled up and thus where fully healed.");
            System.out.println("You have " + getCurrentEP() + " EP of " + getEpToNextLevel() + " EP needed to level up.");
        }
    }

    public String choiceControlOption(String... options) {
        while (true) {
            String choice;
            choice = playerInput();
            if (Arrays.asList(options).contains(choice)) {
                return choice;
            } else {
                System.out.println("Invalid Option, please try again.");
            }
        }
    }

    public int choiceControlInputStringToInteger() throws NotANumberException {
        while (true) {
            int choiceInt;
            String choice;
            choice = playerInput();
            try {
                choiceInt = Integer.parseInt(choice);
                return choiceInt;
            } catch (Exception ex) {
                System.out.println("Invalid Number, please try again");
            }
        }
    }

    public void dying() throws NotANumberException, InterruptedException {
        //TODO: checkpoints
        System.out.println("You died and as I already said there is no respawning in this game.");
        System.out.println("But I'm not that kind of developer that forces you to replay the intro :)");
        System.out.println("Back to the first fight:");
        Adventure.story.adventureTimeLine();
    }

    public String choiceControlWeapon(HashMap<String, Weapon> nameToWeapon, boolean magicAttack) throws NotANumberException {
        while (true) {
            String choice;
            choice = playerInput();
            if (nameToWeapon.containsKey(choice)) {
                return choice;
            }
            int choiceInt = -1;
            try {
                choiceInt = Integer.parseInt(choice);
            } catch (Exception ex) {
                System.out.println("Invalid Number, please try again");
            }
            if (choiceInt >= 0 && (meleeWeaponsNumber.containsValue(choiceInt) || magicWeaponsNumber.containsValue(choiceInt))) {
                if (magicAttack) {
                    return magicWeaponsName.get(magicWeaponsNumberToWeapon.get(Integer.parseInt(choice)));
                } else {
                    return meleeWeaponsName.get(meleeWeaponsNumberToWeapon.get(Integer.parseInt(choice)));
                }
            } else if (choiceInt > 0) {
                System.out.println("Invalid Weapon, please try again.");
            }
        }
    }

    public String choiceControlHeal(HashMap<String, Heal> nameToHeal) {
        while (true) {
            String choice;
            choice = playerInput();
            if (nameToHeal.containsKey(choice)) {
                return choice;
            } else if (healNumber.containsValue(Integer.parseInt(choice))) {
                return healName.get(healNumberToHeal.get(Integer.parseInt(choice)));
            }
            else {
                System.out.println("Invalid Heal, please try again.");
            }
            if (getPlayerHealth() > getPlayerMaxHealth()) {
                setPlayerHealth(getPlayerMaxHealth());
            }
        }
    }

    public void playerDamageCalculation(Weapon weapon, Enemy enemy) {
        enemy.setHealth(enemy.getHealth() - (getPlayerBaseDamage() + weapon.getWeaponDamage()));
        System.out.println("You dealt " + (getPlayerBaseDamage() + weapon.getWeaponDamage()) + " DMG to the " + enemy.getDisplayName());
    }

    public void selectChosenHealAndHeal(String chosenHeal) {
        setPlayerHealth(getPlayerHealth() + healNameToHeal.get(chosenHeal).getHealthRestored());
        System.out.println("You healed yourself by " + healNameToHeal.get(chosenHeal).getHealthRestored() + " HP");
    }

    public void fightPattern(Enemy enemy, int thisEnemyLevel, boolean attacks, boolean magic) throws NotANumberException, InterruptedException {
        String action;
        if (magic) {
            System.out.println("Do you want to attack (ATK), use magic (MAGIC) or heal (HEAL) ?");
            action = choiceControlOption("ATK", "MAGIC", "HEAL");
            switch (action) {
                case "ATK":
                    listMeleeWeaponsInInv();
                    System.out.println("Chose your weapon");
                    String chosenMeleeWeapon;
                    chosenMeleeWeapon = choiceControlWeapon(meleeWeaponsNameToWeapon, false);
                    playerDamageCalculation(meleeWeaponsNameToWeapon.get(chosenMeleeWeapon), enemy);
                    break;
                case "MAGIC":
                    listMagicWeaponsInInv();
                    System.out.println("Chose your magic");
                    String chosenMagic;
                    chosenMagic = choiceControlWeapon(magicWeaponsNameToWeapon, true);
                    playerDamageCalculation(magicWeaponsNameToWeapon.get(chosenMagic), enemy);
                    break;
                case "HEAL":
                    listHealsInInv();
                    System.out.println("What heal do you want to use?");
                    String chosenHeal;
                    chosenHeal = choiceControlHeal(healNameToHeal);
                    selectChosenHealAndHeal(chosenHeal);
                    System.out.println("You healed by " + healNameToHeal.get(chosenHeal).getHealthRestored() + " HP");
                    System.out.println("Player: \n Health: " + getPlayerHealth());
                    break;
            }
        } else {
            System.out.println("Do you want to attack (ATK) or heal (HEAL) ?");
            action = choiceControlOption("ATK", "HEAL");
            switch (action) {
                case "ATK":
                    listMeleeWeaponsInInv();
                    System.out.println("Chose your weapon");
                    String chosenMeleeWeapon;
                    chosenMeleeWeapon = choiceControlWeapon(meleeWeaponsNameToWeapon, false);
                    playerDamageCalculation(meleeWeaponsNameToWeapon.get(chosenMeleeWeapon), enemy);
                    break;
                case "HEAL":
                    listHealsInInv();
                    System.out.println("What heal do you want to use?");
                    String chosenHeal;
                    chosenHeal = choiceControlHeal(healNameToHeal);
                    selectChosenHealAndHeal(chosenHeal);
                    System.out.println("You healed by " + healNameToHeal.get(chosenHeal).getHealthRestored() + " HP");
                    System.out.println("Player: \n Health: " + getPlayerHealth());
                    break;
            }
        }
        if (magic) {
            if (enemy.getHealth() <= 0) {
                System.out.println("The " + enemy.getDisplayName() + " was defeated.");
                System.out.println("Player: \n Health: " + getPlayerHealth() + "\n Mana: " + getPlayerMana());
                System.out.println("You gain " + enemy.experienceYieldCalculation(thisEnemyLevel) + " EP");
                playerLevelCalculation(enemy, thisEnemyLevel);
            } else if (attacks) {
                System.out.println("The " + enemy.getDisplayName() + " attacked you!");
                setPlayerHealth(getPlayerHealth() - enemy.damageCalculation(thisEnemyLevel));
                System.out.println("You lost " + enemy.damageCalculation(thisEnemyLevel) + " HP");
                System.out.println("Player: \n Health: " + getPlayerHealth() + "\n Mana: " + getPlayerMana());
                System.out.println(enemy.getDisplayName() + ": \n Health: " + enemy.getHealth());
                System.out.println("The " + enemy.getDisplayName() + " healed by " + enemy.getHealthRegen());
                enemy.setHealth(enemy.getHealth() + enemy.getHealthRegen());
                System.out.println(enemy.getDisplayName() + ": \n Health: " + enemy.getHealth());
            } else {
                System.out.println("Player: \n Health: " + getPlayerHealth() + "\n Mana: " + getPlayerMana());
                System.out.println(enemy.getDisplayName() + ": \n Health: " + enemy.getHealth());
                System.out.println("The " + enemy.getDisplayName() + " healed by " + enemy.getHealthRegen());
                enemy.setHealth(enemy.getHealth() + enemy.getHealthRegen());
                System.out.println(enemy.getDisplayName() + ": \n Health: " + enemy.getHealth());
            }
        } else {
            if (enemy.getHealth() <= 0) {
                System.out.println("The " + enemy.getDisplayName() + " was defeated.");
                System.out.println("Player: \n Health: " + getPlayerHealth());
                System.out.println("You gain " + enemy.experienceYieldCalculation(thisEnemyLevel) + " EP");
                playerLevelCalculation(enemy, thisEnemyLevel);
            } else if (attacks) {
                System.out.println("The " + enemy.getDisplayName() + " attacked you!");
                setPlayerHealth(getPlayerHealth() - enemy.damageCalculation(thisEnemyLevel));
                System.out.println("You lost " + enemy.damageCalculation(thisEnemyLevel) + " HP");
                System.out.println("Player: \n Health: " + getPlayerHealth());
                System.out.println(enemy.getDisplayName() + ": \n Health: " + enemy.getHealth());
                System.out.println("The " + enemy.getDisplayName() + " healed by " + enemy.getHealthRegen());
                enemy.setHealth(enemy.getHealth() + enemy.getHealthRegen());
                System.out.println(enemy.getDisplayName() + ": \n Health: " + enemy.getHealth());
            } else {
                System.out.println("Player: \n Health: " + getPlayerHealth());
                System.out.println(enemy.getDisplayName() + ": \n Health: " + enemy.getHealth());
                System.out.println("The " + enemy.getDisplayName() + " healed by " + enemy.getHealthRegen());
                enemy.setHealth(enemy.getHealth() + enemy.getHealthRegen());
                System.out.println(enemy.getDisplayName() + ": \n Health: " + enemy.getHealth());
            }
        }
        if (getPlayerHealth() <= 0) {
            dying();
        }
    }

    public void meleeOnlyFight(Enemy enemy, boolean attacks) throws NotANumberException, InterruptedException {
        boolean enemyAlive = true;
        int thisEnemyLevel;
        thisEnemyLevel = enemy.levelCalculation(getPlayerLevel());
        System.out.println("An " + enemy.getDisplayName() + " Level " + thisEnemyLevel + " appeared.");
        System.out.println("Player: \n Health: " + getPlayerHealth());
        enemy.setHealth(enemy.maxHealthCalculation(thisEnemyLevel));
        System.out.println(enemy.getDisplayName() + ": \n Health: " + enemy.getHealth());
        while (enemyAlive) {
            fightPattern(enemy, thisEnemyLevel, attacks, false);
            if (enemy.getHealth() <= 0) {
                enemyAlive = false;
            }
        }
    }

    public void firstBossFight(Enemy enemy) throws NotANumberException, InterruptedException {
        boolean bossAlive = true;
        int bossStage = 1;
        System.out.println("You woke the old evil laying here from its slumber.");
        System.out.println("An " + enemy.getDisplayName() + " Level " + enemy.getLevel() + " has appeared.");
        System.out.println("Player: \n Health: " + playerHealth);
        enemy.setHealth(enemy.getMaxHealth());
        System.out.println(enemy.getDisplayName() + ": \n Health: " + enemy.getHealth());
        while(bossAlive) {
            while (bossStage == 1) {
                System.out.println("The Ogre emits a frightening Aura.");                       //Pokemon Su/Mo EasterEgg
                fightPattern(enemy, enemy.getLevel(), true, false);
                if (enemy.getHealth() <= 30) {
                    bossStage++;
                }
            }
            int chargePhase2 = 0;
            System.out.println("The Ogre was enraged by you attacking it.");
            while (bossStage == 2) {
                switch (chargePhase2) {
                    case 0:
                        System.out.println("The Ogre seems to be more concentrated.");
                        break;
                    case 1:
                        System.out.println("The Ogre seems to be gathering Energy.");
                        break;
                    case 2:
                        System.out.println("The Ogre has gathered an astounding amount of Energy.");
                        break;
                    case 3:
                        System.out.println("The Ogre is preparing an attack.");
                        break;
                    default:
                        System.out.println("An Error has occurred, please report this bug to the developer.");
                        break;
                }
                fightPattern(enemy, enemy.getLevel(), true, false);
                if (getPlayerHealth() <= 10) {
                    System.out.println("Mysterious Voice: You should heal, the Ogre seems kinda dangerous.");
                }
                chargePhase2++;
                if (chargePhase2 == 3) {
                    System.out.println("The Ogre unleashed the attack it was charging.");
                    setPlayerHealth(getPlayerHealth() - 10);
                    System.out.println("Player: \n Health: " + getPlayerHealth());
                    chargePhase2 = 0;
                }
                if (enemy.getHealth() <= 5) {
                    bossStage++;
                }
            }
            int chargePhase3 = 0;
            enemy.setMobConstant(20);
            enemy.setHealth(25);
            System.out.println("The Ogre healed itself.");
            System.out.println("Ogre: \n Health: " + enemy.getHealth());
            System.out.println("The Ogres is not gathering Energy anymore but now a Dark Aura begins to wrap around the old castle.");
            System.out.println("Mysterious Voice: We should hurry, defeat this thing and leave. I really don't like this Dark Aura.");
            while (bossStage == 3) {
                fightPattern(enemy, enemy.getLevel(), true, false);
                switch (chargePhase3) {
                    case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
                        System.out.println("The Dark Aura is getting stronger.");
                        break;
                    case 10: case 11:
                        System.out.println("The air is getting heavier and harder to breathe as a the sky gets black.");
                        break;
                    case 12: case 13: case 14: case 15:
                        System.out.println("A wind begins to pick up and makes black waves course through the air.");
                        break;
                    default:
                        System.out.println("Black waves surging through the air hit and hurt you.");
                        if (getPlayerHealth() > 1) {
                            setPlayerHealth(getPlayerHealth() - 1);
                            System.out.println("Player: \n Health: " + getPlayerHealth());
                        }
                        break;
                }
                chargePhase3++;
                if (enemy.getHealth() <= 0) {
                    bossAlive = false;
                    System.out.println("The Dark Energy Waves are now circulating around you, slowly descending towards you.");
                    System.out.println("You, panicking: What is happening?");
                    System.out.println("You get hit by the Dark Energy and black out.");
                }
            }
        }
    }
}

