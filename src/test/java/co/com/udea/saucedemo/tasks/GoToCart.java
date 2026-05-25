package co.com.udea.saucedemo.tasks;

import co.com.udea.saucedemo.ui.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToCart implements Task {

    @Override
    @Step("{0} navega al carrito de compras")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.CART_ICON)
        );
    }

    public static GoToCart page() {
        return instrumented(GoToCart.class);
    }
}
