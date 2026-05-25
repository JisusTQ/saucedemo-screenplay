package co.com.udea.saucedemo.interactions;

import co.com.udea.saucedemo.ui.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

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

    public static ClickRemoveFromCart forProduct(String productDataTestId) {
        return instrumented(ClickRemoveFromCart.class, productDataTestId);
    }
}
