package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

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
