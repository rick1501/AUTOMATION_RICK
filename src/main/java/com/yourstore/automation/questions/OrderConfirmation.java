package com.yourstore.automation.questions;

import com.yourstore.automation.ui.CheckoutPageUI;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;

public class OrderConfirmation implements Question<String> {

    public static OrderConfirmation message(){
        return new OrderConfirmation();
    }

    @Override
    public String answeredBy(Actor actor) {
        return CheckoutPageUI.CONFIRMATION_MESSAGE.resolveFor(actor).getText();
    }
}