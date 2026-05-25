package co.com.udea.saucedemo.stepdefinitions;

import co.com.udea.saucedemo.tasks.ProcessCheckout;
import co.com.udea.saucedemo.questions.CheckoutMessage;
import co.com.udea.saucedemo.questions.CheckoutError;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

/**
 * STEP DEFINITIONS: conecta los pasos de checkout.feature con el patron
 * Screenplay.
 * <p>
 * Los steps de inicio de sesion y adicion de productos al carrito son
 * reutilizados
 * desde LoginStepDefinitions y CartStepDefinitions, permitiendo que este flujo
 * se concentre exclusivamente en el formulario de envio y la confirmacion del
 * pago.
 * <p>
 * El stage y el actor en escena ya vienen inicializados por los pasos previos.
 */
public class CheckoutStepDefinitions {
    @Cuando("procede a realizar el pago con los datos {string}, {string} y {string}")
    public void procedeARealizarElPagoConLosDatos(String firstName, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcessCheckout.withData(firstName, lastName, postalCode));
    }

    @Entonces("deberia ver el mensaje de confirmacion {string}")
    public void deberiaVerElMensajeDeConfirmacion(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("el mensaje final del checkout", CheckoutMessage.text(), equalTo(mensajeEsperado)));
    }

    @Entonces("deberia ver el mensaje de error en el checkout {string}")
    public void deberiaVerElMensajeDeError(String mensajeErrorEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("el mensaje de validación del formulario", CheckoutError.message(),
                        equalTo(mensajeErrorEsperado)));
    }
}
