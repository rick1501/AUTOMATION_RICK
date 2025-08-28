package com.yourstore.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePageUI {
    public static final Target MY_ACCOUNT = Target.the("My Account menu").locatedBy("//a[@title='My Account']");
    public static final Target REGISTER = Target.the("Register link").locatedBy("//a[normalize-space()='Register']");
    public static final Target LOGIN = Target.the("Login link").locatedBy("//a[normalize-space()='Login']");
    public static final Target LAPTOPS_MENU = Target.the("Laptops & Notebooks top menu").locatedBy("//a[contains(.,'Laptops & Notebooks')]");
    public static final Target SHOW_ALL_LAPTOPS = Target.the("Show all Laptops & Notebooks").locatedBy("//a[normalize-space()='Show All Laptops & Notebooks']");
    public static final Target SEARCH_BOX = Target.the("Search box").locatedBy("//input[@name='search']");
    public static final Target SEARCH_BUTTON = Target.the("Search button").locatedBy("//button[contains(@class,'btn') and contains(.,'Search')]|//button[@type='button' and contains(@class,'btn') and contains(.,'Search')] | //button[contains(@class,'btn-default')]");
    public static Target addToCartButtonForProduct(String name){
        return Target.the("Add to cart for " + name)
            .locatedBy("//div[contains(@class,'product-thumb')]//a[normalize-space()='{0}']/ancestor::div[contains(@class,'product-thumb')]//button[contains(@onclick,'cart.add')]").of(name);
    }
    public static Target productLinkByName(String name){
        return Target.the("Product link: " + name)
            .locatedBy("//div[contains(@class,'product-thumb')]//a[normalize-space()='{0}']").of(name);
    }
    public static final Target CART_DROPDOWN = Target.the("Top cart dropdown").locatedBy("//div[@id='cart']");
    public static final Target VIEW_CART = Target.the("View Cart link").locatedBy("//strong[contains(.,'View Cart')]|//a[contains(.,'View Cart')]");
    public static final Target CHECKOUT_IN_DROPDOWN = Target.the("Checkout link in cart dropdown").locatedBy("//strong[contains(.,'Checkout')]|//a[contains(.,'Checkout')]");
}