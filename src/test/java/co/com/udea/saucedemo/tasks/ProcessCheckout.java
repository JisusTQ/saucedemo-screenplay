package co.com.udea.saucedemo.tasks;

import co.com.udea.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;

public class ProcessCheckout implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public ProcessCheckout(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static ProcessCheckout withData(String firstName, String lastName, String postalCode) {
        return Tasks.instrumented(ProcessCheckout.class, firstName, lastName, postalCode);
    }

    @Override
    @Step("{0} procesa el checkout con los datos: Nombre '{0}', Apellido '{1}', Código Postal '{2}'")
    public <T extends Actor> void performAs(T actor) {
        String currentUrl = Serenity.getDriver().getCurrentUrl();
        if (!currentUrl.contains("cart")) {
            actor.attemptsTo(GoToCart.page());
        }

        actor.attemptsTo(
                Click.on(CheckoutPage.CHECKOUT_BUTTON),
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME),
                Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE),
                Click.on(CheckoutPage.CONTINUE_BUTTON));

        if (!firstName.isEmpty() && !lastName.isEmpty() && !postalCode.isEmpty()) {
            actor.attemptsTo(
                    Click.on(CheckoutPage.FINISH_BUTTON));
        }
    }
}