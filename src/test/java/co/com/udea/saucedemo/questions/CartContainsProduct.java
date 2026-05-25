package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class CartContainsProduct implements Question<Boolean> {

    private final String productName;

    public CartContainsProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            List<String> itemTexts = CartPage.CART_ITEMS
                    .resolveAllFor(actor)
                    .stream()
                    .map(el -> el.getText())
                    .toList();
            return itemTexts.stream().anyMatch(text -> text.contains(productName));
        } catch (Exception e) {
            return false;
        }
    }

    public static CartContainsProduct named(String productName) {
        return new CartContainsProduct(productName);
    }
}
