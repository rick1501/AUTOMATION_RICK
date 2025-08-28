package com.yourstore.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPageUI {

    //public static final Target CART_TABLE = Target.the("Cart table").locatedBy("//table[contains(@class,'table')]");
    public static final Target CART_TABLE  = Target.the("BTNELI")
            .located(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[4]/div/span/button[2]"));

    public static Target quantityForProduct(String name){
        return Target.the("Quantity input for product " + name)
            .locatedBy("//tr[.//a[normalize-space()='{0}']]//input[contains(@name,'quantity')]").of(name);
    }
    public static Target updateButtonForProduct(String name){
        return Target.the("Update button for product " + name)
            .locatedBy("//tr[.//a[normalize-space()='{0}']]//button[contains(@data-original-title,'Update') or contains(@class,'btn') and contains(.,'Update')]").of(name);
    }
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout button").locatedBy("//a[contains(@class,'btn') and contains(.,'Checkout')]");
}