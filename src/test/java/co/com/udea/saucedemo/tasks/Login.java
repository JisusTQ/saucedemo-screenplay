package co.com.udea.saucedemo.tasks;

import co.com.udea.saucedemo.interactions.EnterCredentials;
import co.com.udea.saucedemo.ui.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    @Step("{0} inicia sesion en Swag Labs")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(LoginPage.URL),
                EnterCredentials.with(username, password),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
    public static Login withCredentials(String username, String password) {
        return instrumented(Login.class, username, password);
    }
}
