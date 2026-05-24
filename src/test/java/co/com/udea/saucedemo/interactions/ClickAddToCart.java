package co.com.udea.saucedemo.interactions;

import co.com.udea.saucedemo.ui.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * INTERACTION: hace clic en el boton "Add to cart" de un producto especifico.
 * <p>
 * Recibe el identificador del producto tal como aparece en el atributo
 * data-test del boton. Ejemplos de valores validos:
 * <ul>
 *   <li>"sauce-labs-backpack"</li>
 *   <li>"sauce-labs-bike-light"</li>
 *   <li>"sauce-labs-bolt-t-shirt"</li>
 *   <li>"sauce-labs-fleece-jacket"</li>
 *   <li>"sauce-labs-onesie"</li>
 *   <li>"test.allthethings()-t-shirt-(red)"</li>
 * </ul>
 */
public class ClickAddToCart implements Interaction {

    private final String productDataTestId;

    public ClickAddToCart(String productDataTestId) {
        this.productDataTestId = productDataTestId;
    }

    @Override
    @Step("{0} hace clic en 'Add to cart' del producto {productDataTestId}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.addToCartButtonOf(productDataTestId))
        );
    }

    /**
     * Metodo fabrica legible.
     * Uso: ClickAddToCart.forProduct("sauce-labs-backpack")
     */
    public static ClickAddToCart forProduct(String productDataTestId) {
        return instrumented(ClickAddToCart.class, productDataTestId);
    }
}
