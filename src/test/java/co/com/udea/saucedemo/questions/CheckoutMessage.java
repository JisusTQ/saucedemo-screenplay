package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * QUESTION: devuelve el mensaje de exito en la pantalla final de confirmacion
 * de compra.
 */
public class CheckoutMessage implements Question<String> {

    public static CheckoutMessage text() {
        return new CheckoutMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CheckoutPage.THANK_YOU_HEADER).answeredBy(actor);
    }
}