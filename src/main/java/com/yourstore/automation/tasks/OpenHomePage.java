package com.yourstore.automation.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Actor;

public class OpenHomePage implements Task {

    private static final String URL = "http://opencart.abstracta.us";

    public static OpenHomePage open(){
        return new OpenHomePage();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(URL));
    }
}