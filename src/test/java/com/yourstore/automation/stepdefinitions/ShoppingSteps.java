package com.yourstore.automation.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import com.yourstore.automation.tasks.*;
import com.yourstore.automation.questions.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class ShoppingSteps {

    // ========================
    // GIVEN STEPS
    // ========================

    @Given("the user registers a new account")
    public void userRegisters() {
        OnStage.theActorCalled("User").wasAbleTo(
                OpenHomePage.open()
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterUser.withRandomData()
        );
    }

    @Given("logs into the application")
    public void userLogsIn() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginUser.withRegisteredCredentials()
        );
    }



    // ========================
    // WHEN STEPS
    // ========================

    @When("the user navigates to Laptops & Notebooks and shows all laptops")
    public void navigateToLaptops() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateToLaptops.section()
        );
    }

    @When("adds a MacBook Pro to the cart")
    public void addMacBook() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductToCart.called("MacBook Pro")
        );
    }

    @When("searches for {string} and adds it to the cart")
    public void searchAndAdd(String query) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchAndAddToCart.product(query, "Samsung Galaxy Tab 10.1")
        );
    }

    @When("removes the MacBook Pro from the cart")
    public void removeMacBook() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RemoveProductFromCart.called("MacBook Pro")
        );
    }

    @When("increases the quantity of Samsung Galaxy Tab in the cart")
    public void increaseQuantity() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IncreaseQuantity.of("Samsung Galaxy Tab 10.1", 2)
        );
    }

    @When("completes the checkout process")
    public void completesCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteCheckout.now()
        );
    }

    // ========================
    // THEN STEPS
    // ========================

    @Then("the order should be confirmed successfully")
    public void validateOrder() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(OrderConfirmation.message(),
                        containsString("Your order has been placed"))
        );
    }
}
