package co.com.udea.saucedemo.tasks;

import co.com.udea.saucedemo.interactions.ClickAddToCart;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;


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

    public static AddProductToCart withId(String productDataTestId) {
        return instrumented(AddProductToCart.class, productDataTestId);
    }
}
