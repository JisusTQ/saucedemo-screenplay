package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * QUESTION: verifica que el actor esta viendo la pagina del carrito de compras.
 * <p>
 * Devuelve el texto del titulo de la pagina del carrito. Si la navegacion al
 * carrito fue correcta, ese texto debe ser "Your Cart".
 */
public class CartTitle {

    public static Question<String> text() {
        return Text.of(CartPage.PAGE_TITLE);
    }

    private CartTitle() {
    }
}
