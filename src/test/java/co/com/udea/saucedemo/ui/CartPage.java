package co.com.udea.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Mapa de elementos de la pagina del carrito de compras (/cart.html).
 * <p>
 * Se accede desde el icono del carrito en la barra de navegacion.
 */
public class CartPage {

    /** Lista de items dentro del carrito. */
    public static final Target CART_ITEMS =
            Target.the("items en el carrito").locatedBy(".cart_item");

    /**
     * Nombre de un item especifico dentro del carrito, buscado por texto exacto.
     * Usa contains() para mayor robustez ante espacios extra en el DOM.
     *
     * @param productName  nombre visible del producto tal como aparece en la UI.
     */
    public static Target cartItemNamed(String productName) {
        return Target.the("item '" + productName + "' en el carrito")
                .locatedBy("//div[@class='inventory_item_name'][normalize-space()='" + productName + "']");
    }

    /** Boton "Checkout" para proceder al pago. */
    public static final Target CHECKOUT_BUTTON =
            Target.the("boton checkout").locatedBy("[data-test='checkout']");

    /** Boton "Continue Shopping" para volver al inventario. */
    public static final Target CONTINUE_SHOPPING_BUTTON =
            Target.the("boton continuar comprando").locatedBy("[data-test='continue-shopping']");

    private CartPage() {
        // Clase de constantes: no se instancia.
    }
}
