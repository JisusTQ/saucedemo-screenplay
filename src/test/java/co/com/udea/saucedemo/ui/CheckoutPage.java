package co.com.udea.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class CheckoutPage {
        public static final Target CHECKOUT_BUTTON = Target.the("botón de Checkout")
                        .located(By.id("checkout"));

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

        public static final Target FINISH_BUTTON = Target.the("botón Finish")
                        .located(By.name("finish"));

        public static final Target THANK_YOU_HEADER = Target.the("encabezado de agradecimiento")
                        .located(By.className("complete-header"));
}
