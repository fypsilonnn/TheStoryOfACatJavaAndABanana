package com.f_ypsilonnn.tsoacjab.sidequests;

import com.f_ypsilonnn.tsoacjab.exceptions.NotANumberException;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Sidequest {

    int difficultyLevel;                          //0-4, 0 = ez - 4 = hard, immer am jeweiligen boss gemessen  //d.h. vor boss 1 = lvl 0 quests, nach boss 1 = lvl 1 quests, usw
    int experienceYield;

    String sidequestName;
    String questDescription;

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setExperienceYield(int experienceYield) {
        this.experienceYield = experienceYield;
    }

    public int getExperienceYield() {
        return experienceYield;
    }

    public void setSidequestName(String sidequestName) {
        this.sidequestName = sidequestName;
    }

    public String getSidequestName() {
        return sidequestName;
    }

    public void setQuestDescription(String questDescription) {
        this.questDescription = questDescription;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public void questLine() throws NotANumberException, InterruptedException {
        //story of sidequest takes place in here
    }

}
