package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.HomePageUI;
import com.yourstore.automation.ui.LoginPageUI;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class LoginUser implements Task {

    private final String email;
    private final String password;

    public LoginUser(String email, String password){
        this.email = email;
        this.password = password;
    }

    public static LoginUser withRegisteredCredentials(){
        return new LoginUser(RegisterUser.SessionData.email, RegisterUser.SessionData.password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(HomePageUI.MY_ACCOUNT),
            Click.on(HomePageUI.LOGIN),
            WaitUntil.the(LoginPageUI.EMAIL, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
            Enter.theValue(email).into(LoginPageUI.EMAIL),
            Enter.theValue(password).into(LoginPageUI.PASSWORD),
            Click.on(LoginPageUI.LOGIN_BUTTON)
        );
    }
}