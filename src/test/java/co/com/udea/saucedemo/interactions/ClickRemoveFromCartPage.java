package co.com.udea.saucedemo.interactions;

import co.com.udea.saucedemo.ui.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

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

    public static ClickRemoveFromCartPage forProduct(String productDataTestId) {
        return instrumented(ClickRemoveFromCartPage.class, productDataTestId);
    }
}
