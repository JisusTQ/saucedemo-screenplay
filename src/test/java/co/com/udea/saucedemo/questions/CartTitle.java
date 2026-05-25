package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CartTitle {

    public static Question<String> text() {
        return Text.of(CartPage.PAGE_TITLE);
    }

    private CartTitle() {
    }
}
