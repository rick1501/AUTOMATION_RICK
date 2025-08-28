package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.CartPageUI;
import com.yourstore.automation.ui.CheckoutPageUI;
import com.yourstore.automation.ui.HomePageUI;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class CompleteCheckout implements Task {

    public static CompleteCheckout now(){
        return new CompleteCheckout();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(HomePageUI.CART_DROPDOWN),
            Click.on(HomePageUI.VIEW_CART),
            WaitUntil.the(CartPageUI.CART_TABLE, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
            Click.on(CartPageUI.CHECKOUT_BUTTON),

            // Billing Address (if requested)
            WaitUntil.the(CheckoutPageUI.BILLING_FIRSTNAME, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
            Enter.theValue(RegisterUser.SessionData.firstName).into(CheckoutPageUI.BILLING_FIRSTNAME),
            Enter.theValue(RegisterUser.SessionData.lastName).into(CheckoutPageUI.BILLING_LASTNAME),
            Enter.theValue("123 Main St").into(CheckoutPageUI.BILLING_ADDRESS),
            Enter.theValue("Bogota").into(CheckoutPageUI.BILLING_CITY),
            Enter.theValue("110111").into(CheckoutPageUI.BILLING_POSTCODE),
            SelectFromOptions.byVisibleText("Colombia").from(CheckoutPageUI.BILLING_COUNTRY),
            SelectFromOptions.byIndex(1).from(CheckoutPageUI.BILLING_ZONE),
            Click.on(CheckoutPageUI.CONTINUE_BILLING),

            // Delivery Address
            WaitUntil.the(CheckoutPageUI.CONTINUE_DELIVERY_ADDRESS, WebElementStateMatchers.isClickable()).forNoMoreThan(20).seconds(),
            Click.on(CheckoutPageUI.CONTINUE_DELIVERY_ADDRESS),

            // Delivery Method
            WaitUntil.the(CheckoutPageUI.CONTINUE_DELIVERY_METHOD, WebElementStateMatchers.isClickable()).forNoMoreThan(20).seconds(),
            Click.on(CheckoutPageUI.CONTINUE_DELIVERY_METHOD),

            // Payment Method
            WaitUntil.the(CheckoutPageUI.TERMS_CHECKBOX, WebElementStateMatchers.isClickable()).forNoMoreThan(20).seconds(),
            Click.on(CheckoutPageUI.TERMS_CHECKBOX),
            Click.on(CheckoutPageUI.CONTINUE_PAYMENT_METHOD),

            // Confirm
            WaitUntil.the(CheckoutPageUI.CONFIRM_ORDER, WebElementStateMatchers.isClickable()).forNoMoreThan(20).seconds(),
            Click.on(CheckoutPageUI.CONFIRM_ORDER)
        );
    }
}