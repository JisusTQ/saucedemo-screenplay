package co.com.udea.saucedemo.tasks;

import co.com.udea.saucedemo.interactions.ClickRemoveFromCart;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * TASK: "eliminar un producto del carrito".
 * <p>
 * Hace clic en el boton "Remove" del producto indicado desde la pagina
 * de inventario. El detalle tecnico vive en {@link ClickRemoveFromCart}.
 */
public class RemoveProductFromCart implements Task {

    private final String productDataTestId;

    public RemoveProductFromCart(String productDataTestId) {
        this.productDataTestId = productDataTestId;
    }

    @Override
    @Step("{0} elimina el producto '{productDataTestId}' del carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickRemoveFromCart.forProduct(productDataTestId)
        );
    }

    /**
     * Metodo fabrica legible.
     * Uso: RemoveProductFromCart.withId("sauce-labs-backpack")
     */
    public static RemoveProductFromCart withId(String productDataTestId) {
        return instrumented(RemoveProductFromCart.class, productDataTestId);
    }
}
