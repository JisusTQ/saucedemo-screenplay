package co.com.udea.saucedemo.tasks;

import co.com.udea.saucedemo.interactions.ClickRemoveFromCartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

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
    public static RemoveProductFromCartPage withId(String productDataTestId) {
        return instrumented(RemoveProductFromCartPage.class, productDataTestId);
    }
}
