package co.com.udea.saucedemo.interactions;

import co.com.udea.saucedemo.ui.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * INTERACTION: hace clic en el boton "Remove" de un producto ya agregado al carrito.
 * <p>
 * El boton "Remove" aparece en la pagina de inventario reemplazando al boton
 * "Add to cart" una vez que el producto fue agregado.
 */
public class ClickRemoveFromCart implements Interaction {

    private final String productDataTestId;

    public ClickRemoveFromCart(String productDataTestId) {
        this.productDataTestId = productDataTestId;
    }

    @Override
    @Step("{0} hace clic en 'Remove' del producto {productDataTestId}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.removeButtonOf(productDataTestId))
        );
    }

    /**
     * Metodo fabrica legible.
     * Uso: ClickRemoveFromCart.forProduct("sauce-labs-backpack")
     */
    public static ClickRemoveFromCart forProduct(String productDataTestId) {
        return instrumented(ClickRemoveFromCart.class, productDataTestId);
    }
}
