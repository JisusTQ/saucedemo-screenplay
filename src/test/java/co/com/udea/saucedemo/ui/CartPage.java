package co.com.udea.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Mapa de elementos de la pagina del carrito de compras (/cart.html).
 * <p>
 * Se accede desde el icono del carrito en la barra de navegacion.
 */
public class CartPage {

    /** Titulo visible de la pagina del carrito. En Swag Labs dice "Your Cart". */
    public static final Target PAGE_TITLE =
            Target.the("titulo de la pagina del carrito").locatedBy(".title");

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

    /**
     * Boton "Remove" que aparece dentro de cada item del carrito (en /cart.html).
     * Permite quitar el producto estando ya en la pagina del carrito.
     *
     * @param productDataTestId  parte del data-test del boton remove,
     *                           en minusculas con guiones (ej: "sauce-labs-backpack").
     */
    public static Target removeButtonOf(String productDataTestId) {
        return Target.the("boton eliminar del carrito de " + productDataTestId)
                .locatedBy("[data-test='remove-" + productDataTestId + "']");
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
