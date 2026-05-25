package co.com.udea.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {

    public static final Target PAGE_TITLE =
            Target.the("titulo de la pagina de productos").locatedBy(".title");

    public static final Target INVENTORY_CONTAINER =
            Target.the("contenedor de inventario").locatedBy("#inventory_container");

    public static Target addToCartButtonOf(String productDataTestId) {
        return Target.the("boton agregar al carrito de " + productDataTestId)
                .locatedBy("[data-test='add-to-cart-" + productDataTestId + "']");
    }

    public static Target removeButtonOf(String productDataTestId) {
        return Target.the("boton eliminar del carrito de " + productDataTestId)
                .locatedBy("[data-test='remove-" + productDataTestId + "']");
    }

    public static final Target CART_BADGE =
            Target.the("badge del carrito").locatedBy(".shopping_cart_badge");

    public static final Target CART_ICON =
            Target.the("icono del carrito").locatedBy(".shopping_cart_link");

    private InventoryPage() {
    }
}
