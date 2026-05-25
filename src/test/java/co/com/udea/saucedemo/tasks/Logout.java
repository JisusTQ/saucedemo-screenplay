package co.com.udea.saucedemo.tasks;

import co.com.udea.saucedemo.ui.LogoutPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Logout implements Task {

    @Override
    @Step("{0} cierra sesion en Swag Labs")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LogoutPage.BURGER_MENU),
                Click.on(LogoutPage.LOGOUT_LINK)
        );
    }

    public static Logout fromTheApplication() {
        return instrumented(Logout.class);
    }
}
