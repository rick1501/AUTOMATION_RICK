package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.HomePageUI;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class AddProductToCart implements Task {
    private final String productName;

    public AddProductToCart(String productName){
        this.productName = productName;
    }

    public static AddProductToCart called(String productName){
        return new AddProductToCart(productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(HomePageUI.addToCartButtonForProduct(productName), WebElementStateMatchers.isClickable()).forNoMoreThan(20).seconds(),
            Click.on(HomePageUI.addToCartButtonForProduct(productName))
        );
    }
}