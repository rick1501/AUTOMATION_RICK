package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.CartPageUI;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class IncreaseQuantity implements Task {

    private final String productName;
    private final int amount;

    public IncreaseQuantity(String productName, int amount){
        this.productName = productName;
        this.amount = amount;
    }

    public static IncreaseQuantity of(String productName, int by){
        return new IncreaseQuantity(productName, by);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(CartPageUI.quantityForProduct(productName), WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
            Clear.field(CartPageUI.quantityForProduct(productName)),
            Enter.theValue(String.valueOf(amount)).into(CartPageUI.quantityForProduct(productName)),
            Click.on(CartPageUI.updateButtonForProduct(productName))
        );
    }
}