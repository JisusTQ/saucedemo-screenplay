package co.com.udea.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Mapa de elementos de la pagina de productos (inventario), a la que se llega
 * tras un login exitoso. Sirve para verificar que el ingreso fue correcto.
 * <p>
 * NOTA para el equipo: Ana Maria y Juan Pablo pueden ampliar esta clase con
 * los Targets de productos, boton "Add to cart", el badge del carrito, etc.
 */
public class InventoryPage {

    /** Titulo visible de la pagina de productos. En Swag Labs dice "Products". */
    public static final Target PAGE_TITLE =
            Target.the("titulo de la pagina de productos").locatedBy(".title");

    public static final Target INVENTORY_CONTAINER =
            Target.the("contenedor de inventario").locatedBy("#inventory_container");

    private InventoryPage() {
        // Clase de constantes: no se instancia.
    }
}
