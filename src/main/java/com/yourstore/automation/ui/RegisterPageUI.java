package com.yourstore.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPageUI {
    public static final Target FIRST_NAME = Target.the("First name").locatedBy("//input[@id='input-firstname']");
    public static final Target LAST_NAME = Target.the("Last name").locatedBy("//input[@id='input-lastname']");
    public static final Target EMAIL = Target.the("Email").locatedBy("//input[@id='input-email']");
    public static final Target TELEPHONE = Target.the("Telephone").locatedBy("//input[@id='input-telephone']");
    public static final Target PASSWORD = Target.the("Password").locatedBy("//input[@id='input-password']");
    public static final Target CONFIRM_PASSWORD = Target.the("Confirm password").locatedBy("//input[@id='input-confirm']");
    public static final Target PRIVACY_CHECK = Target.the("Privacy Policy checkbox").locatedBy("//input[@name='agree']");
    public static final Target CONTINUE_BUTTON = Target.the("Continue button").locatedBy("//input[@type='submit' and (@value='Continue' or contains(@class,'btn'))]");
    public static final Target SUCCESS_HEADER = Target.the("Success header").locatedBy("//div[@id='content']//h1");
    public static final Target CONTINUE_AFTER_SUCCESS = Target.the("Continue after success").locatedBy("//a[normalize-space()='Continue']");
    public static final Target LOGOUT = Target.the("BTNLOGOUT")
            .located(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a"));

}