package co.com.udea.saucedemo.interactions;

import co.com.udea.saucedemo.ui.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * INTERACTION: hace clic en el boton "Remove" de un producto estando ya dentro
 * de la pagina del carrito (/cart.html).
 * <p>
 * Se diferencia de {@link ClickRemoveFromCart}, que elimina desde la pagina de
 * inventario: aqui el boton vive dentro del item listado en el carrito.
 */
public class ClickRemoveFromCartPage implements Interaction {

    private final String productDataTestId;

    public ClickRemoveFromCartPage(String productDataTestId) {
        this.productDataTestId = productDataTestId;
    }

    @Override
    @Step("{0} hace clic en 'Remove' del producto {productDataTestId} dentro del carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.removeButtonOf(productDataTestId))
        );
    }

    /**
     * Metodo fabrica legible.
     * Uso: ClickRemoveFromCartPage.forProduct("sauce-labs-backpack")
     */
    public static ClickRemoveFromCartPage forProduct(String productDataTestId) {
        return instrumented(ClickRemoveFromCartPage.class, productDataTestId);
    }
}
