package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.CartPageUI;
import com.yourstore.automation.ui.HomePageUI;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class RemoveProductFromCart implements Task {

    private final String productName;

    public RemoveProductFromCart(String productName){
        this.productName = productName;
    }

    public static RemoveProductFromCart called(String productName){
        return new RemoveProductFromCart(productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(HomePageUI.CART_DROPDOWN),
            Click.on(HomePageUI.VIEW_CART),
            WaitUntil.the(CartPageUI.CART_TABLE, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
            Click.on(CartPageUI.CART_TABLE )
        );
    }
}