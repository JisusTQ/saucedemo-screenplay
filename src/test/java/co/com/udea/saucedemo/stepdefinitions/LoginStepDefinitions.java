package co.com.udea.saucedemo.stepdefinitions;

import co.com.udea.saucedemo.tasks.Logout;
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

/**
 * STEP DEFINITIONS: conecta los pasos de login.feature y cart.feature
 * con el patron Screenplay.
 * <p>
 * El @Before inicializa el stage. Los steps Dado/Cuando de login son
 * reutilizados por cart.feature, garantizando que el stage siempre
 * este listo antes de cualquier accion sobre el carrito.
 */
public class LoginStepDefinitions {

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void limpiarEscenario() {
        try {
            // Hace logout para limpiar el carrito en el servidor antes de cerrar
            OnStage.theActorInTheSpotlight().attemptsTo(Logout.fromTheApplication());
        } catch (Exception ignored) {
            // Si el logout falla (ej: escenario de login fallido), ignorar
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
                Login.withCredentials(usuario, contrasena)
        );
    }

    @Entonces("deberia ver la pagina de productos")
    public void deberiaVerLaPaginaDeProductos() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("el titulo de la pagina", InventoryTitle.text(), equalTo("Products"))
        );
    }

    @Entonces("deberia ver el mensaje de error {string}")
    public void deberiaVerElMensajeDeError(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("el mensaje de error", ErrorMessage.text(), containsString(mensajeEsperado))
        );
    }
}
