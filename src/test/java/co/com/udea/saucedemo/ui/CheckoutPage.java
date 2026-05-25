package co.com.udea.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapa de elementos de las paginas del proceso de checkout
 * (/checkout-step-one.html, /checkout-step-two.html, /checkout-complete.html).
 * <p>
 * Se accede haciendo clic en el boton "Checkout" desde la pagina del carrito de
 * compras.
 */
public class CheckoutPage {
        // Si estás en el carrito, se necesita el botón para iniciar checkout
        public static final Target CHECKOUT_BUTTON = Target.the("botón de Checkout")
                        .located(By.id("checkout"));

        // Paso 1: Información (Imagen 1)
        public static final Target FIRST_NAME = Target.the("campo primer nombre")
                        .located(By.id("first-name"));
        public static final Target LAST_NAME = Target.the("campo apellido")
                        .located(By.id("last-name"));
        public static final Target POSTAL_CODE = Target.the("campo código postal")
                        .located(By.id("postal-code"));
        public static final Target CONTINUE_BUTTON = Target.the("botón Continue")
                        .located(By.id("continue"));
        public static final Target ERROR_MESSAGE = Target.the("mensaje de error del formulario")
                        .located(By.cssSelector("[data-test='error']"));

        // Paso 2: Resumen / Overview (Imagen 2)
        public static final Target FINISH_BUTTON = Target.the("botón Finish")
                        .located(By.name("finish"));

        // Paso 3: Confirmación completa (Imagen 3)
        public static final Target THANK_YOU_HEADER = Target.the("encabezado de agradecimiento")
                        .located(By.className("complete-header"));
}
