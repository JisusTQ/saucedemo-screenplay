package co.com.udea.saucedemo.interactions;

import co.com.udea.saucedemo.ui.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

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

    public static ClickAddToCart forProduct(String productDataTestId) {
        return instrumented(ClickAddToCart.class, productDataTestId);
    }
}
