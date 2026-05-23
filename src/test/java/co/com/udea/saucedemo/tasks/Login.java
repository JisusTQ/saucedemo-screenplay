package co.com.udea.saucedemo.tasks;

import co.com.udea.saucedemo.interactions.EnterCredentials;
import co.com.udea.saucedemo.ui.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * TASK (en terminos del negocio): "iniciar sesion".
 * <p>
 * Una Task describe QUE hace el actor en lenguaje del negocio, sin entrar en
 * el detalle tecnico. El detalle vive en las Interactions y en los Targets.
 * <p>
 * Pasos:
 *   1. Abrir la pagina de Swag Labs.
 *   2. Digitar las credenciales (Interaction EnterCredentials).
 *   3. Hacer clic en el boton de ingreso.
 */
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

    /** Metodo fabrica legible: Login.withCredentials("user", "pass") */
    public static Login withCredentials(String username, String password) {
        return instrumented(Login.class, username, password);
    }
}
