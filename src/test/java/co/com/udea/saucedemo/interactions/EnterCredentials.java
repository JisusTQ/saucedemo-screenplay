package co.com.udea.saucedemo.interactions;

import co.com.udea.saucedemo.ui.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterCredentials implements Interaction {

    private final String username;
    private final String password;

    public EnterCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    @Step("{0} digita el usuario y la contrasena")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD)
        );
    }

    public static EnterCredentials with(String username, String password) {
        return instrumented(EnterCredentials.class, username, password);
    }
}
