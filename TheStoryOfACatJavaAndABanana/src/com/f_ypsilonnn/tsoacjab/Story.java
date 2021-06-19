package com.f_ypsilonnn.tsoacjab;

import com.f_ypsilonnn.tsoacjab.enemies.Boss1Ogre;
import com.f_ypsilonnn.tsoacjab.enemies.Goblin;
import com.f_ypsilonnn.tsoacjab.exceptions.NotANumberException;
import com.f_ypsilonnn.tsoacjab.sidequests.Sidequest;
import com.sun.xml.internal.ws.server.ServerRtException;
import sun.util.resources.CalendarData;

import java.util.ArrayList;


public class Story {
    //TODO: ein paar TimeUnit.ZEITEINHEIT.sleep timeouts einbauen

    ArrayList<Sidequest> availableSidequests = new ArrayList<>();
    ArrayList<Sidequest> level0Sidequests = new ArrayList<>();
    ArrayList<Sidequest> level1Sidequests = new ArrayList<>();
    ArrayList<Sidequest> level2Sidequests = new ArrayList<>();
    ArrayList<Sidequest> level3Sidequests = new ArrayList<>();
    ArrayList<Sidequest> level4Sidequests = new ArrayList<>();

    public void addToAvailableSidequests(ArrayList<Sidequest> toAdd) {
        //TODO: nach jedem Boss die neuen Sidequests adden
        for (int i = 0; i < toAdd.size(); i++) {
            availableSidequests.add(toAdd.get(i));
        }
    }

    public void sidequestListing() {
        for (int i = 0; i < availableSidequests.size(); i++) {
            System.out.println((i + 1) + availableSidequests.get(i).getSidequestName() + "\n" + availableSidequests.get(i).getQuestDescription());
        }
    }

    public void choosingASidequest() throws NotANumberException, InterruptedException {
        int choiceInt;
        String confirmation;
        System.out.println("Genesis: So which of these do you wanna do?");
        sidequestListing();
        choiceInt = Adventure.p1.choiceControlInputStringToInteger();
        System.out.println("Are you sure you want to accept this quest? (Y/N)");
        confirmation = Adventure.p1.choiceControlOption("Y", "N");
        if (confirmation.equals("Y")) {
            doingASidequest(availableSidequests.get(choiceInt));
        } else {
            System.out.println("Do you want to accept a different Quest (DIFF) or do not accept any Quests (NOQ) ?");
            String choice;
            choice = Adventure.p1.choiceControlOption("DIFF", "NOQ");
            if (choice.equals("DIFF")) {
                choosingASidequest();
            } else {
                System.out.println("You leave the billboard.");
            }
        }
    }

    public void doingASidequest(Sidequest activeSidequest) throws NotANumberException, InterruptedException {
        activeSidequest.questLine();
        System.out.println("You gain " + activeSidequest.getExperienceYield() + " EP for doing the quest");
        Adventure.p1.setCurrentEP(Adventure.p1.getCurrentEP() + activeSidequest.getExperienceYield());
        if (Adventure.p1.getCurrentEP() > Adventure.p1.getEpToNextLevel()) {
            Adventure.p1.levelingUp();
        }
        if (availableSidequests.size() > 0) {
            System.out.println("Do you want to do another Sidequest? (Y/N)");
            String choice;
            choice = Adventure.p1.choiceControlOption("Y", "N");
            switch (choice) {
                case "Y":
                    System.out.println("Genesis: Sounds good, which of these you wanna do?");
                    choosingASidequest();
                    break;
                case "N":
                    System.out.println("Genesis: Yeah, you're right, that was probably enough.");
            }
        } else {
            System.out.println("There are no more Sidequests available, play further into the game to unlock more!");
        }
    }

    public void adventureTimeLine() throws NotANumberException, InterruptedException {
        Adventure.p1.setPlayerLevel(1);
        Adventure.p1.setEpToNextLevel(10);
        Adventure.p1.setCurrentEP(0);
        Adventure.p1.setPlayerMaxHealth(20);
        Adventure.p1.setPlayerHealth(Adventure.p1.getPlayerMaxHealth());
        Adventure.p1.setPlayerMaxMana(0);
        Adventure.p1.setPlayerBaseDamage(0);

        theFirstFight();
        tripToVanatiaCity();
        searchingTheOldManInVanatia();
        arrivingAtTheLakeOfWrath();
        secondTimeInVanatiaCity();

        theVanatiaForest();
        theFirstBossfight();
    }

    public void intro() {
        System.out.println("Mysterious Voice: Oh no your cat was stolen! You have to defeat the unnatural evil that stole it to get back your beloved cat.");
        System.out.println("You go out your little hut in the Woods and meet an old man");
        System.out.println("Old Man: Here take this, it's dangerous to go alone.");         //TLOZ EasterEgg
        System.out.println("Simple short sword obtained");
        Adventure.p1.addMeleeWeaponToInv(Adventure.shortSword, Adventure.shortSword.getWeaponName());
        Adventure.p1.addHealToInv(Adventure.basicHeal, Adventure.basicHeal.getHealDisplayName());
        System.out.println("You continue searching for information about the whereabouts of your cat");
        System.out.println("Mysterious Voice: Be careful, there is something lingering in the bushes to your left.");
        System.out.println("You inspect the crackling bush and find a GOBLIN");
        System.out.println("");
    }

    public void tutorialFights() {
        System.out.println("Mysterious Voice: You got into a fight. In a fight you can either attack or heal yourself. Both of these actions cost you MP (MANA POINTS).");
        System.out.println("Mysterious Voice: Fights are fought in a round by round System. First you attack yourself, then the enemy attacks.");
        System.out.println("Mysterious Voice: If you get hit by an enemy you lose HP (HEALTH POINTS). If your HP drop to Zero you die and will stay dead forever, no reviving in this game.");
        System.out.println("Mysterious Voice: Your enemies regain some HP every Round. If you kill an enemy you gain EP (EXPERIENCE POINTS). After reaching a certain amount of EP you LEVEL up.");
        System.out.println("Mysterious Voice: Each LEVEL you gain the possibility to upgrade your HP, MP or DMG (BASE DAMAGE)");
        System.out.println("Mysterious Voice: Possible actions will be given in Brackets: ()");
        System.out.println("Mysterious Voice: Now go on and defeat your first enemy.");
        System.out.println("");
    }

    public void theFirstFight() throws NotANumberException {
        Adventure.p1.meleeOnlyFight(new Goblin(), true);
    }

    public void tripToVanatiaCity() throws NotANumberException {
        System.out.println("Mysterious Voice: Phew... that wasn't quite easy. You should level up some more so you don't die.");
        System.out.println("Mysterious Voice: Anyway, let's go to Vanatia City. On your way there it's quite possible that you meet some more goblins.");
        System.out.println("You can either try to avoid them or try to kill them to level up some more.");
        System.out.println("You begin walking towards Vanatia City");
        System.out.println("You, again, here crackling in a bush, do you want to inspect it? (Y/N)");
        String choice;
        choice = Adventure.p1.choiceControlOption("Y", "N");
        switch (choice) {
            case "Y":
                Adventure.p1.meleeOnlyFight(new Goblin(), true);
                System.out.println("A second goblin seems to have heard the fight and now attacks you");
                Adventure.p1.meleeOnlyFight(new Goblin(), true);
                System.out.println("After your fight you go onwards to Vanatia City");
                break;
            case "N":
                break;
        }
        System.out.println("You arrived in Vanatia City");
        System.out.println("");
        System.out.println("Mysterious Voice: I have heard of a wise man living somewhere in this City, you should go ask him for help.");
        System.out.println("You, mumbling: I've too heard of this old man... WAIT, who are you anyways?");
        System.out.println("Mysterious Voice: Time's not ready for me to tell you who I am. Also u can just think what you want to say to me.");
        System.out.println("You, still mumbling: Why does this have to happen to me above all?");
        System.out.println("Mysterious Voice: Well, at least I am helping you. Now you probably should go on searching that old man.");
        System.out.println("You, now thinking: Ugh... fine, do you, at least, have any clue where he could be?");
        System.out.println("Mysterious Voice: Not at all.");
        System.out.println("You: Well then it's just going to be trial and error.");
        System.out.println("You start searching the old man.");
        System.out.println("");
    }

    public void searchingTheOldManInVanatia() {
        System.out.println("You, thinking: Maybe I should ask someone about this old man.");
        System.out.println("You go further into the City and arrive at the market");
        System.out.println("You stroll to a market stall and start talking to the man standing there");
        System.out.println("You: Hey, that's quite the nice smell.");
        System.out.println("Vendor: Thanks dude, want some?");
        System.out.println("You: Sure, can I get some of this pie?");
        System.out.println("Vendor: Here you go.");
        System.out.println("You: Mhhhhm, delicious. By the way, can you tell me something about this wise man that's supposed to live here?");
        System.out.println("Vendor: I'm sorry, I don't know that much either, but he's supposed to live somewhere in the north of the Town.");
        System.out.println("You: Well, thanks for the pie. I'm gonna go on searching then.");
        System.out.println("You finish eating your pie");
        System.out.println("");
        System.out.println("Going north you travel through the craftsman's quarter of Vanatia.");
        System.out.println("Mysterious Voice: Hey, see that smithing shop over there? You should let them look at your blade, maybe they can enhance it.");
        System.out.println("You: Yeah, your probably right. Anyway, could you stop ordering me around?");
        System.out.println("You go into the shop");
        System.out.println("You: Eh chief, could you take a look at my blade?");
        System.out.println("Smith: Only if you got something to pay for it.");
        System.out.println("You: Sure.");
        System.out.println("You draw your blade and hand it to the Smith");
        System.out.println("Smith: Ugh, that blades no good. It's rusty and all dull.");
        System.out.println("You: Yeah, I thought that, could you fix it up?");
        System.out.println("Smith: I could do that, it'll take a while tho, it should take me about 'til tomorrow.");
        System.out.println("You: Kay, see you tomorrow then.");
        System.out.println("You leave the smithing shop and stand there just outside the door.");
        System.out.println("You: Uhh, we probably shouldn't go somewhere outside the city without a weapon. So... so... WAIT! What's your name anyways?");
        System.out.println("Mysterious Voice: Well I'm not gonna tell you my name, you can call me Genesis.");
        System.out.println("You: Then I'm gonna start searching for an inn to stay the night in.");
        System.out.println("Walking back, deeper into the City you start looking for an Inn");
        System.out.println("After some searching you find a place to stay for the night and go to sleep after eating dinner");
        Adventure.p1.healPlayerOutOfFight(Adventure.p1.getPlayerMaxHealth());
        System.out.println("Sleeping replenished your strength, you are fully healed");
        System.out.println("After breakfast you go back to the smithing shop and enter it");
        System.out.println("Smith: Ah your back, I just finished polishing your sword. Here take it, it's back to its former glory.");
        System.out.println("You: It really looks nice, thanks chief.");
        System.out.println("Your SHORT SWORD was upgraded and now deals 4 DAMAGE");
        Adventure.p1.removeMeleeWeaponFromInv(Adventure.shortSword, Adventure.shortSword.getWeaponName());
        Adventure.p1.addMeleeWeaponToInv(Adventure.cleanShortSword, Adventure.cleanShortSword.getWeaponName());
        System.out.println("You: By the way chief, do you know something about this wise, old man that's supposed to live somewhere in the north of this town?");
        System.out.println("Smith: Yeah sure, he lives in a small hut at the lake of Wrath, north to this town.");          //Pokemon EasterEgg
        System.out.println("You: Thanks for letting me know and the nice Sword and the information.");
        System.out.println("Smith: Sure, be safe.");
        System.out.println("You leave the shop.");
        System.out.println("");
        System.out.println("You: So, let's go to that lake he talked about.");
        System.out.println("You walk towards the North Gate of Vanatia and leave the town");
        System.out.println("");
    }

    public void arrivingAtTheLakeOfWrath() {
        System.out.println("A warm wind is blowing when you arrive at the lake.");
        System.out.println("Rounding the gigantic Lake, you find the small hut. Knocking on the door, you hear someone from within.");
        System.out.println("Voice: I'm coming young boy, wait for the old man.");
        System.out.println("The door opens and before you stands a very old man with a white beard about twice as long as he is tall. Not to say that he was that tall, probably about 165cm.");
        System.out.println("Wise Man: Young Boy, visitors are quite uncommon out here. Come in you must be fatigued by your travel out here.");
        System.out.println("Entering the shack, you take a look at the small room the man seems to live in.");
        System.out.println("Wise Man: What did bring you out here to visit me?");
        System.out.println("You: Well my Cat got abducted. And now I want to get it back.");
        System.out.println("Wise Man: And how do you want me to help you with that young boy, supposing that you especially visited me.");
        System.out.println("You: Well, I need to know where I gotta search for it. And since I've heard about you being a wise man I thought about asking you.");
        System.out.println("Wise Man: I am for sure not the wrong person to ask, but I am not sure either if I am the right one. I suppose you could search the old ruins somewhere in the forest east of here, there is some old evil lingering.");
        System.out.println("You: I have seen those ruins from a distance quite some times while hunting in the forest. I never thought about them as a place of evil.");
        System.out.println("Wise Man: They are not completely evil, I am sure of that. But when I was a young boy, many years ago there was something evil occupying it. So after all those years it is possible that the evil did return.");
        System.out.println("You: So you think I'm gonna find my cat there?");
        System.out.println("Wise Man: I am sure you will not find your cat there, but it is likely that you find some hints.");
        System.out.println("You: Thanks, you were of great help.");
        System.out.println("Wise Man. Your welcome young boy. No go on your way and save your cat.");
        System.out.println("You leave the Lake of wrath and travel back to Vanatia City.");
    }

    public void secondTimeInVanatiaCity() throws NotANumberException, InterruptedException {
        addToAvailableSidequests(level0Sidequests);
        //TODO: sidequest
        System.out.println("Back in Vanatia City");
        System.out.println("You walk back to the city center searching for a place to stay the night.");
        System.out.println("While searching for an inn, you see a billboard on the side of the town square.");
        System.out.println("On the billboard there are request written by some people of the town.");
        //TODO: paar mehr quests (1-2)
        sidequestListing();
        System.out.println("Genesis: Maybe we should help some of the people here in order to level up and maybe get some items to");
        System.out.println("Do you want to do some sidequests? (Y, N) \n (Developer Note: Yes, you should)");
        String choice1;
        choice1 = Adventure.p1.choiceControlOption("Y", "N");
        switch (choice1) {
            case "Y":
                choosingASidequest();
                System.out.println("You: Yeah, you're right there. I guess I'll do some of them");
                break;
            case "N":
                System.out.println("Genesis: Are you sure about that? The part of the forest the old man talked about seems really dangerous. (Y (do not take a sidequest)/N (take a sidequest)");
                String choice2;
                choice2 = Adventure.p1.choiceControlOption("Y", "N");
                switch (choice2) {
                    case "Y":
                        break;
                    case "N":
                        choosingASidequest();
                        System.out.println("You: Yeah, you're right there. I guess I'll do some of them");
                        break;
                }
                break;
        }
    }

    public void theVanatiaForest() {
        //TODO: suche nach dem Boss
        System.out.println("");
        System.out.println("This part is still under development!");
        System.out.println("");
    }

    public void theFirstBossfight() throws NotANumberException {
        System.out.println("You arrive at the old ruins. There is an ill feeling in the air. ");
        System.out.println("You enter the ruins, searching the source of the ill feeling.");
        System.out.println("Arriving at the center square you see a strange being lying on the ground.");
        System.out.println("You step closer to the being. Suddenly it rises from the ground.");
        Adventure.p1.firstBossFight(new Boss1Ogre());
        addToAvailableSidequests(level1Sidequests);
    }

}
