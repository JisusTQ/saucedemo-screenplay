package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * QUESTION: devuelve la cantidad de productos que muestra el carrito de compras.
 * <p>
 * Cuenta los items ({@code .cart_item}) presentes en la pagina /cart.html.
 * Devuelve {@code 0} si el carrito esta vacio.
 */
public class CartItemCount implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        try {
            return CartPage.CART_ITEMS.resolveAllFor(actor).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public static CartItemCount displayed() {
        return new CartItemCount();
    }
}
