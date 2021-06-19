package com.f_ypsilonnn.tsoacjab;

import com.f_ypsilonnn.tsoacjab.enemies.Boss1Ogre;
import com.f_ypsilonnn.tsoacjab.enemies.Goblin;
import com.f_ypsilonnn.tsoacjab.enemies.MinibossTallGoblin;
import com.f_ypsilonnn.tsoacjab.exceptions.NotANumberException;
import com.f_ypsilonnn.tsoacjab.heals.AdvancedHeal;
import com.f_ypsilonnn.tsoacjab.heals.BasicHeal;
import com.f_ypsilonnn.tsoacjab.sidequests.CarriyngLogs1;
import com.f_ypsilonnn.tsoacjab.sidequests.SheepProtection1;
import com.f_ypsilonnn.tsoacjab.sidequests.Sidequest;
import com.f_ypsilonnn.tsoacjab.weapons.CleanShortSword;
import com.f_ypsilonnn.tsoacjab.weapons.ShortSword;
import com.f_ypsilonnn.tsoacjab.weapons.SwordOfTheUniverse;

import java.util.ArrayList;

public class Adventure {
    //TODO: installer
    //TODO: savegame
    //TODO: balancing

    //saves
    //TODO: durch json ersetzen
    //TODO: beim tod die stats auf die am letzten cp zurücksetzen, BOSSE = CHECKPOINTS
    public static int checkPoint;                         //der CP an dem man ist
    public static int playerLevelAtCheckPoint;
    public static int playerEPToNextLevelAtCheckPoint;
    public static int playerCurrentEPAtCheckPoint;
    public static int playerMaxHealthAtCheckPoint;
    public static int playerHealthAtCheckPoint;
    public static int playerMaxManaAtCheckPoint;
    public static int playerManaAtCheckPoint;
    public static int playerBaseDamageAtCheckPoint;

    //one of a kind
    public static Player p1;
    public static Story story;

    //sidequests

    //level1
    public static SheepProtection1 sheepProtection1;
    public static CarriyngLogs1 carriyngLogs1;
    //level2

    //level3

    //level4

    //weapons
    public static SwordOfTheUniverse swordOfTheUniverse;
    public static ShortSword shortSword;
    public static CleanShortSword cleanShortSword;

    //heals
    public static BasicHeal basicHeal;
    public static AdvancedHeal advancedHeal;

    //enemies
    public static Goblin goblin1;

    //minibosses
    public static MinibossTallGoblin minibossTallGoblin;

    //bosses
    public static Boss1Ogre boss1Ogre;


    public static void main(String[] args) throws NotANumberException, InterruptedException {
        //one of a kind
        p1 = new Player();
        story = new Story();

        //sidequests
        //level0
        sheepProtection1 = new SheepProtection1();
        carriyngLogs1 = new CarriyngLogs1();
            //adding the Sidequests
        story.level0Sidequests.add(sheepProtection1);
        story.level0Sidequests.add(carriyngLogs1);
        //level1
            //adding the Sidequests
        //level2
            //adding the Sidequests
        //level3
            //adding the Sidequests
        //level4
            //adding the Sidequests

        //weapons
        swordOfTheUniverse = new SwordOfTheUniverse();
        shortSword = new ShortSword();
        cleanShortSword = new CleanShortSword();

        //heals
        basicHeal = new BasicHeal();


        //enemies
        goblin1 = new Goblin();

        //minibosses
        minibossTallGoblin = new MinibossTallGoblin();

        //bosses
        boss1Ogre = new Boss1Ogre();

        //TODO: SOTU nach engültigem test entfernen
        p1.addMeleeWeaponToInv(Adventure.swordOfTheUniverse, "SOTU");

        //TODO: storybau

        /*
        switch(checkPoint) {
            case 0:
                story.intro();
                story.tutorialFights();
                checkPoint++;
            case 1:
                Adventure.story.theFirstFight();
                Adventure.story.tripToVanatiaCity();
                Adventure.story.searchingTheOldManInVanatia();
                Adventure.story.arrivingAtTheLakeOfWrath();
                Adventure.story.theVanatiaForest();
                Adventure.story.theFirstBossfight();
                checkPoint++;
            case 2:
                //ALLES NACH 1st BOSS
        }
         */


        story.intro();
        story.tutorialFights();


        story.adventureTimeLine();
    }

    public static void setCheckPoint(int checkPoint) {
        Adventure.checkPoint = checkPoint;
    }

    public static int getCheckPoint() {
        return checkPoint;
    }

}
