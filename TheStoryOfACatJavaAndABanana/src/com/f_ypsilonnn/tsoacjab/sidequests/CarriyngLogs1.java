package com.f_ypsilonnn.tsoacjab.sidequests;

import com.f_ypsilonnn.tsoacjab.Adventure;

import java.sql.SQLOutput;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class CarriyngLogs1 extends Sidequest {

    public CarriyngLogs1() {
        difficultyLevel = 0;
        experienceYield = 4;
        sidequestName = "Carrying Logs";
        questDescription = "\"HELP! \n I need help with carrying some logs to my House\"";
    }

    @Override
    public void questLine() throws InterruptedException {
        System.out.println("You walk to the outskirts of the town to meet the Lumberjack that asked for your help");
        System.out.println("Getting there the Lumberjack notices you");
        System.out.println("Lumberjack: You there, watcha doin out here?");
        System.out.println("You: There was a quest up on the billboard on the town square saying you need help carrying wood.");
        System.out.println("Lumberjack: That's true, I've gotta carry some logs from back in the woods to my hut.");
        System.out.println("You: Well, then let's get started.");
        TimeUnit.SECONDS.sleep(20);
        System.out.println("After finishing you and the Lumberjack say farewell to each other and you go on your way back to town");
    }
}
