package com.f_ypsilonnn.tsoacjab.sidequests;

import com.f_ypsilonnn.tsoacjab.Adventure;
import com.f_ypsilonnn.tsoacjab.enemies.Goblin;
import com.f_ypsilonnn.tsoacjab.enemies.MinibossTallGoblin;
import com.f_ypsilonnn.tsoacjab.exceptions.NotANumberException;

import java.util.concurrent.TimeUnit;

public class SheepProtection1 extends Sidequest {

    public SheepProtection1() {
        difficultyLevel = 0;
        experienceYield = 8;
        sidequestName = "Sheep Protection";
        questDescription = "\"HELP! \n I need someone to protect my sheep from some goblins\"";
    }

    @Override
    public void questLine() throws NotANumberException, InterruptedException {
        System.out.println("You travel to the south of the City, getting there you see some large scale farms");
        System.out.println("Seeing a person working on a field close to the street, you decide to ask where to find the person that put up the quest");
        System.out.println("You: Hey there, do you know where to find Farmer John?");
        System.out.println("Worker: Hi! Farmer John, huh? He had many problems with those nasty goblins the last weeks.");
        System.out.println("You: Well, I'm here to help him with that.");
        System.out.println("Worker: That's good to here. Let's see, where to find John at this time...");
        for (int i = 0; i < 3; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Worker:...");
        }
        System.out.println("Worker: You should be able to find John at his carrots field, it's down the street, 'till you get to a horse stable.");
        System.out.println("Worker: From there on you turn left an walk for a while. After a while you'll see a huge carrots field on your right.");
        System.out.println("Worker: That's where you'll find John.");
        System.out.println("You: Thanks for your help.");
        System.out.println("You go on and follow the path the worker described to you");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Arriving at the carrot field, the worker spoke of, you see a somewhat old man watering the carrots");
        System.out.println("You: Hey you there, are you Farmer John?");
        System.out.println("Farmer: You could say that.");
        System.out.println("You: I'm here because of the Quest you put up at the town square.");
        System.out.println("Farmer John: You are? The heavens bless you, these damn goblin are stealing and eating my sheep every night.");
        System.out.println("Farmer John: If I can't produce and sell enough of those sheep I won't be able to get through winter. It would be a grace if you could slay them.");
        System.out.println("You: I'm here to do exactly that.");
        System.out.println("Farmer John: Since they come at night you can wait here with me whilst I finish watering these carrots.");
        System.out.println("Watching Farmer John watering the plants you begin to gather some information");
        System.out.println("You: So you just want me to guard the sheep for some nights and when goblins come to kill them off?");
        System.out.println("Farmer John: That's true, in this region of Vanatia there aren't many monsters, so if you kill them the attacks will stop.");
        System.out.println("You: Fine, you know how many goblins there are?");
        System.out.println("Farmer John: It's only a handful of them, but their leader seems a bit different.");
        System.out.println("You watch Farmer John doing his work and talk to him until evening breaks");
        TimeUnit.SECONDS.sleep(15);
        System.out.println("Farmer John: We have about two hours left before the goblins attack, come with me I'm hungry and sure you too.");
        System.out.println("You: You're right there.");
        System.out.println("Farmer John leeds you to the main house of his farm and you eat dinner with him an his family");
        Adventure.p1.healPlayerOutOfFight(5);
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Farmer John: It's almost time the goblins attack, come, I'll lead you to the sheep stable.");
        System.out.println("Arriving at the sheep stable you inspect the surroundings.");
        System.out.println("You: I don't see any goblins yet, looks like we'll have to wait for them.");
        System.out.println("Farmer John: I'm gonna watch form a bit further away, just make sure you don'T get yourself killed");
        System.out.println("Sitting on a rock next to the stable entry you start waiting for the goblins to arrive.");
        for (int i = 0; i < 3; i++) {
            TimeUnit.SECONDS.sleep(randomWaitingTime());
            switch (i) {
                case 0:
                    System.out.println("You hear some ruckus to your left as goblin breaks out of the undergrowth");
                    System.out.println("It screams and proceeds to attack you");
                    Adventure.p1.meleeOnlyFight(new Goblin(), true);
                    break;
                case 1:
                    System.out.println("Suddenly a goblin crashes out of the woods in front of you and attacks you whilst screaming");
                    Adventure.p1.meleeOnlyFight(new Goblin(), true);
                    break;
                case 2:
                    System.out.println("A slight chill runs down your back, as a goblin, slightly bigger than other goblins, slowly walks out from where the second goblin came");
                    System.out.println("You and the big goblin approach each other and start to fight");
                    Adventure.p1.meleeOnlyFight(new MinibossTallGoblin(), true);
            }
        }
        System.out.println("You: Phew, that was no easy fight. That should do it John, shouldn't it?");
        System.out.println("Farmer John: Yes, again thank you very much for healping me.");
        System.out.println("Farmer John: If you would like to, you can stay at the farm for tonight.");
        System.out.println("You: I think I'll accept that offer, I'm really tired right now.");
        System.out.println("And so you and John return to the main house and go to sleep. In the next morning you, John and johns family say farewell.");
        System.out.println("You're waving your hand towards John as you make yourself on the way back to the town square");
    }

    public int randomWaitingTime() {
        int min = 4;
        int max = 10;
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }
}
