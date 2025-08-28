package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.HomePageUI;
import com.yourstore.automation.ui.RegisterPageUI;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterUser implements Task {

    public static class SessionData {
        public static String email;
        public static String password;
        public static String firstName = "Test";
        public static String lastName = "User";
        public static String telephone = "123456789";
    }

    public static RegisterUser withRandomData(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        SessionData.email = "user" + timestamp + "@mailinator.com";
        SessionData.password = "Password123!";
        return new RegisterUser();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(HomePageUI.MY_ACCOUNT),
            Click.on(HomePageUI.REGISTER),
            WaitUntil.the(RegisterPageUI.FIRST_NAME, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
            Enter.theValue(SessionData.firstName).into(RegisterPageUI.FIRST_NAME),
            Enter.theValue(SessionData.lastName).into(RegisterPageUI.LAST_NAME),
            Enter.theValue(SessionData.email).into(RegisterPageUI.EMAIL),
            Enter.theValue(SessionData.telephone).into(RegisterPageUI.TELEPHONE),
            Enter.theValue(SessionData.password).into(RegisterPageUI.PASSWORD),
            Enter.theValue(SessionData.password).into(RegisterPageUI.CONFIRM_PASSWORD),
            Click.on(RegisterPageUI.PRIVACY_CHECK),
            Click.on(RegisterPageUI.CONTINUE_BUTTON),
            WaitUntil.the(RegisterPageUI.SUCCESS_HEADER, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
            Click.on(RegisterPageUI.CONTINUE_AFTER_SUCCESS),
                Click.on(HomePageUI.MY_ACCOUNT),
                Click.on(RegisterPageUI.LOGOUT)

        );
    }
}