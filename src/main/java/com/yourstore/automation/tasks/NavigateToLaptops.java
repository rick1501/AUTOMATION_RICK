package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.HomePageUI;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class NavigateToLaptops implements Task {

    public static NavigateToLaptops section(){
        return new NavigateToLaptops();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(HomePageUI.LAPTOPS_MENU),
            WaitUntil.the(HomePageUI.SHOW_ALL_LAPTOPS, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
            Click.on(HomePageUI.SHOW_ALL_LAPTOPS)
        );
    }
}