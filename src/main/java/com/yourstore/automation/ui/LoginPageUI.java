package com.yourstore.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPageUI {
    public static final Target EMAIL = Target.the("Email field").locatedBy("//input[@id='input-email']");
    public static final Target PASSWORD = Target.the("Password field").locatedBy("//input[@id='input-password']");
    public static final Target LOGIN_BUTTON = Target.the("Login button").locatedBy("//input[@value='Login' or @type='submit']");

}