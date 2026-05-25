package co.com.udea.saucedemo.tasks;

import co.com.udea.saucedemo.interactions.ClickRemoveFromCartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * TASK: "eliminar un producto estando dentro del carrito".
 * <p>
 * A diferencia de {@link RemoveProductFromCart} (que elimina desde el listado de
 * inventario), esta task asume que el actor ya esta en la pagina del carrito
 * (/cart.html) y quita el producto desde alli. El detalle tecnico vive en
 * {@link ClickRemoveFromCartPage}.
 */
public class RemoveProductFromCartPage implements Task {

    private final String productDataTestId;

    public RemoveProductFromCartPage(String productDataTestId) {
        this.productDataTestId = productDataTestId;
    }

    @Override
    @Step("{0} elimina el producto '{productDataTestId}' desde la pagina del carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickRemoveFromCartPage.forProduct(productDataTestId)
        );
    }

    /**
     * Metodo fabrica legible.
     * Uso: RemoveProductFromCartPage.withId("sauce-labs-backpack")
     */
    public static RemoveProductFromCartPage withId(String productDataTestId) {
        return instrumented(RemoveProductFromCartPage.class, productDataTestId);
    }
}
