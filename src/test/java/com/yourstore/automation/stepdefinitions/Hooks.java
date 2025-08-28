package com.yourstore.automation.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void tearDown(){
        OnStage.drawTheCurtain();
    }
}