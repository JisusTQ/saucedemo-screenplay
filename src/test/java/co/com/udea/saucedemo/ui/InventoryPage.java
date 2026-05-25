package co.com.udea.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Mapa de elementos de la pagina de productos (inventario), a la que se llega
 * tras un login exitoso.
 * <p>
 * Incluye los Targets para interactuar con productos individuales,
 * el boton "Add to cart" y el badge del carrito.
 */
public class InventoryPage {

    /** Titulo visible de la pagina de productos. En Swag Labs dice "Products". */
    public static final Target PAGE_TITLE =
            Target.the("titulo de la pagina de productos").locatedBy(".title");

    public static final Target INVENTORY_CONTAINER =
            Target.the("contenedor de inventario").locatedBy("#inventory_container");

    /**
     * Boton "Add to cart" de un producto especifico, identificado por su nombre
     * en el atributo data-test.
     * Ejemplo: para "Sauce Labs Backpack" el selector es
     *   [data-test='add-to-cart-sauce-labs-backpack']
     *
     * @param productDataTestId  parte del data-test del boton, en minusculas con guiones.
     */
    public static Target addToCartButtonOf(String productDataTestId) {
        return Target.the("boton agregar al carrito de " + productDataTestId)
                .locatedBy("[data-test='add-to-cart-" + productDataTestId + "']");
    }

    /**
     * Boton "Remove" de un producto ya agregado al carrito.
     *
     * @param productDataTestId  parte del data-test del boton remove.
     */
    public static Target removeButtonOf(String productDataTestId) {
        return Target.the("boton eliminar del carrito de " + productDataTestId)
                .locatedBy("[data-test='remove-" + productDataTestId + "']");
    }

    /** Badge con el numero de items en el icono del carrito. */
    public static final Target CART_BADGE =
            Target.the("badge del carrito").locatedBy(".shopping_cart_badge");

    /** Icono/enlace del carrito en la barra de navegacion. */
    public static final Target CART_ICON =
            Target.the("icono del carrito").locatedBy(".shopping_cart_link");

    private InventoryPage() {
        // Clase de constantes: no se instancia.
    }
}
