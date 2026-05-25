package co.com.udea.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target PAGE_TITLE =
            Target.the("titulo de la pagina del carrito").locatedBy(".title");

    public static final Target CART_ITEMS =
            Target.the("items en el carrito").locatedBy(".cart_item");

    public static Target cartItemNamed(String productName) {
        return Target.the("item '" + productName + "' en el carrito")
                .locatedBy("//div[@class='inventory_item_name'][normalize-space()='" + productName + "']");
    }

    public static Target removeButtonOf(String productDataTestId) {
        return Target.the("boton eliminar del carrito de " + productDataTestId)
                .locatedBy("[data-test='remove-" + productDataTestId + "']");
    }

    public static final Target CHECKOUT_BUTTON =
            Target.the("boton checkout").locatedBy("[data-test='checkout']");

    public static final Target CONTINUE_SHOPPING_BUTTON =
            Target.the("boton continuar comprando").locatedBy("[data-test='continue-shopping']");

    private CartPage() {
    }
}
