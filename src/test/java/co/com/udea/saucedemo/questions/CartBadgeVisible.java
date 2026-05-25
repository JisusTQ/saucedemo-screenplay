package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CartBadgeVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return InventoryPage.CART_BADGE.resolveFor(actor).isVisible();
    }

    public static CartBadgeVisible onScreen() {
        return new CartBadgeVisible();
    }
}
