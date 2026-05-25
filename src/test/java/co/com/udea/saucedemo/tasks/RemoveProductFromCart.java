package co.com.udea.saucedemo.tasks;

import co.com.udea.saucedemo.interactions.ClickRemoveFromCart;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

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

    public static RemoveProductFromCart withId(String productDataTestId) {
        return instrumented(RemoveProductFromCart.class, productDataTestId);
    }
}
