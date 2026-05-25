package co.com.udea.saucedemo.tasks;

import co.com.udea.saucedemo.interactions.ClickAddToCart;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * TASK: "agregar un producto al carrito".
 * <p>
 * Describe la intencion del negocio en lenguaje natural. El detalle tecnico
 * (cual boton hacer clic) vive en la Interaction {@link ClickAddToCart}.
 * <p>
 * El {@code productDataTestId} es la parte del atributo data-test del boton
 * "Add to cart" que identifica al producto. Ejemplos:
 * <ul>
 *   <li>"sauce-labs-backpack"</li>
 *   <li>"sauce-labs-bike-light"</li>
 *   <li>"sauce-labs-bolt-t-shirt"</li>
 * </ul>
 */
public class AddProductToCart implements Task {

    private final String productDataTestId;

    public AddProductToCart(String productDataTestId) {
        this.productDataTestId = productDataTestId;
    }

    @Override
    @Step("{0} agrega el producto '{productDataTestId}' al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickAddToCart.forProduct(productDataTestId)
        );
    }

    /**
     * Metodo fabrica legible.
     * Uso: AddProductToCart.withId("sauce-labs-backpack")
     */
    public static AddProductToCart withId(String productDataTestId) {
        return instrumented(AddProductToCart.class, productDataTestId);
    }
}
