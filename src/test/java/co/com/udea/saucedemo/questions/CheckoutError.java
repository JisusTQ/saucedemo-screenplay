package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CheckoutError implements Question<String> {

    public static CheckoutError message() {
        return new CheckoutError();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CheckoutPage.ERROR_MESSAGE).answeredBy(actor);
    }
}
