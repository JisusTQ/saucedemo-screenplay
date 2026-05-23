package co.com.udea.saucedemo.stepdefinitions;

import co.com.udea.saucedemo.questions.ErrorMessage;
import co.com.udea.saucedemo.questions.InventoryTitle;
import co.com.udea.saucedemo.tasks.Login;
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
 * STEP DEFINITIONS: el "pegamento" entre el Gherkin (login.feature) y el
 * patron Screenplay (Tasks y Questions).
 * <p>
 * Cada metodo traduce un paso del escenario a acciones del actor.
 */
public class LoginStepDefinitions {

    /**
     * Antes de cada escenario preparamos el "escenario teatral" de Screenplay,
     * usando un elenco en linea (OnlineCast) que provee actores con navegador.
     */
    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
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
