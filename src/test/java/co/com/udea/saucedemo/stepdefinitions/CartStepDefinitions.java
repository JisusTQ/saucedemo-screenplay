package co.com.udea.saucedemo.stepdefinitions;

import co.com.udea.saucedemo.questions.CartBadgeCount;
import co.com.udea.saucedemo.questions.CartBadgeVisible;
import co.com.udea.saucedemo.questions.CartContainsProduct;
import co.com.udea.saucedemo.tasks.AddProductToCart;
import co.com.udea.saucedemo.tasks.GoToCart;
import co.com.udea.saucedemo.tasks.RemoveProductFromCart;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * STEP DEFINITIONS: conecta los pasos de cart.feature con el patron Screenplay.
 * <p>
 * Los steps Dado/Cuando de login son reutilizados desde LoginStepDefinitions.
 * El stage ya esta inicializado por LoginStepDefinitions antes de estos steps.
 */
public class CartStepDefinitions {

    @Cuando("agrega el producto {string} al carrito")
    public void agregaElProducto(String productDataTestId) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductToCart.withId(productDataTestId)
        );
    }

    @Cuando("elimina el producto {string} del carrito")
    public void eliminaElProducto(String productDataTestId) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RemoveProductFromCart.withId(productDataTestId)
        );
    }

    @Entonces("el badge del carrito deberia mostrar {string}")
    public void elBadgeDeberiaMostrar(String cantidad) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("el badge del carrito", CartBadgeCount.value(), equalTo(cantidad))
        );
    }

    @Entonces("el carrito deberia contener el producto {string}")
    public void elCarritoDeberiaContener(String nombreProducto) {
        String currentUrl = net.serenitybdd.core.Serenity.getDriver().getCurrentUrl();
        if (!currentUrl.contains("cart")) {
            OnStage.theActorInTheSpotlight().attemptsTo(GoToCart.page());
        }
        OnStage.theActorInTheSpotlight().should(
                seeThat("el producto en el carrito", CartContainsProduct.named(nombreProducto), is(true))
        );
    }

    @Entonces("el badge del carrito no deberia ser visible")
    public void elBadgeNoDeberiaSerVisible() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("la visibilidad del badge del carrito", CartBadgeVisible.onScreen(), is(false))
        );
    }
}
