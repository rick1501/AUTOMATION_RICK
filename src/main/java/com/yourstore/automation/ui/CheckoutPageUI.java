package com.yourstore.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPageUI {
    public static final Target BILLING_FIRSTNAME = Target.the("Billing first name").locatedBy("//input[@id='input-payment-firstname']");
    public static final Target BILLING_LASTNAME = Target.the("Billing last name").locatedBy("//input[@id='input-payment-lastname']");
    public static final Target BILLING_ADDRESS = Target.the("Billing address").locatedBy("//input[@id='input-payment-address-1']");
    public static final Target BILLING_CITY = Target.the("Billing city").locatedBy("//input[@id='input-payment-city']");
    public static final Target BILLING_POSTCODE = Target.the("Billing postcode").locatedBy("//input[@id='input-payment-postcode']");
    public static final Target BILLING_COUNTRY = Target.the("Billing country select").locatedBy("//select[@id='input-payment-country']");
    public static final Target BILLING_ZONE = Target.the("Billing region/state select").locatedBy("//select[@id='input-payment-zone']");
    public static final Target CONTINUE_BILLING = Target.the("Continue after billing address").locatedBy("//input[@id='button-payment-address' or @id='button-payment'] | //button[@id='button-payment-address'] | //button[contains(.,'Continue')]");
    public static final Target CONTINUE_DELIVERY_ADDRESS = Target.the("Continue after delivery address").locatedBy("//input[@id='button-shipping-address' or @id='button-shipping'] | //button[contains(.,'Continue') and contains(@onclick,'shipping')]");
    public static final Target CONTINUE_DELIVERY_METHOD = Target.the("Continue after delivery method").locatedBy("//input[@id='button-shipping-method'] | //button[contains(.,'Continue') and contains(@onclick,'shipping_method')]");
    public static final Target TERMS_CHECKBOX = Target.the("Terms and conditions checkbox").locatedBy("//input[@name='agree']");
    public static final Target CONTINUE_PAYMENT_METHOD = Target.the("Continue after payment method").locatedBy("//input[@id='button-payment-method'] | //button[contains(.,'Continue') and contains(@onclick,'payment_method')]");
    public static final Target CONFIRM_ORDER = Target.the("Confirm order button").locatedBy("//input[@id='button-confirm' or @value='Confirm Order'] | //button[contains(.,'Confirm')]");
    public static final Target CONFIRMATION_MESSAGE = Target.the("Order confirmation message").locatedBy("//div[@id='content']//h1 | //div[@id='content']//p");
}