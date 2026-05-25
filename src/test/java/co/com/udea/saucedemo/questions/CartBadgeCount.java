package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CartBadgeCount implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        try {
            return InventoryPage.CART_BADGE
                    .resolveFor(actor)
                    .getText()
                    .trim();
        } catch (Exception e) {
            return "";
        }
    }

    public static CartBadgeCount value() {
        return new CartBadgeCount();
    }
}
