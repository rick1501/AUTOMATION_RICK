package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.HomePageUI;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class SearchAndAddToCart implements Task {

    private final String query;
    private final String productName;

    public SearchAndAddToCart(String query, String productName){
        this.query = query;
        this.productName = productName;
    }

    public static SearchAndAddToCart product(String query, String productName){
        return new SearchAndAddToCart(query, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(query).into(HomePageUI.SEARCH_BOX),
            Click.on(HomePageUI.SEARCH_BUTTON),
            WaitUntil.the(HomePageUI.addToCartButtonForProduct(productName), WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
            Click.on(HomePageUI.addToCartButtonForProduct(productName))
        );
    }
}