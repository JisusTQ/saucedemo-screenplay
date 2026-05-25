package co.com.udea.saucedemo.stepdefinitions;

import co.com.udea.saucedemo.tasks.Logout;
import co.com.udea.saucedemo.ui.LoginPage;
import co.com.udea.saucedemo.questions.ErrorMessage;
import co.com.udea.saucedemo.questions.InventoryTitle;
import co.com.udea.saucedemo.tasks.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class LoginStepDefinitions {

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void limpiarEscenario() {
        try {
            boolean loginFallo = LoginPage.ERROR_MESSAGE
                    .resolveFor(OnStage.theActorInTheSpotlight())
                    .isVisible();

            if (!loginFallo) {
                OnStage.theActorInTheSpotlight().attemptsTo(Logout.fromTheApplication());
            }
        } catch (Exception ignored) {
        }
        OnStage.drawTheCurtain();
    }

    @Dado("que {string} esta en la pagina de inicio de Swag Labs")
    public void queEstaEnLaPaginaDeInicio(String nombreActor) {
        OnStage.theActorCalled(nombreActor);
    }

    @Cuando("intenta iniciar sesion con el usuario {string} y la contrasena {string}")
    public void intentaIniciarSesion(String usuario, String contrasena) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(usuario, contrasena));
    }

    @Entonces("deberia ver la pagina de productos")
    public void deberiaVerLaPaginaDeProductos() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("el titulo de la pagina", InventoryTitle.text(), equalTo("Products")));
    }

    @Entonces("deberia ver el mensaje de error {string}")
    public void deberiaVerElMensajeDeError(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("el mensaje de error", ErrorMessage.text(), containsString(mensajeEsperado)));
    }
}
