package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * QUESTION: indica si el badge del carrito esta visible en pantalla.
 * <p>
 * Devuelve {@code true} si hay al menos un producto en el carrito
 * (el badge es visible), {@code false} si el carrito esta vacio.
 */
public class CartBadgeVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return InventoryPage.CART_BADGE.resolveFor(actor).isVisible();
    }

    /** Metodo fabrica legible. Uso: CartBadgeVisible.onScreen() */
    public static CartBadgeVisible onScreen() {
        return new CartBadgeVisible();
    }
}
