package co.com.udea.saucedemo.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.Serenity;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * INTERACTION: cierra el popup "Cambia tu contrasena" de Chrome si aparece.
 * <p>
 * Chrome muestra este popup cuando detecta que la contrasena usada esta en
 * una brecha de seguridad. Como es un dialogo del navegador (no de la pagina),
 * se maneja via JavaScript o buscando el boton "Aceptar" en el shadow DOM.
 */
public class DismissPasswordPopup implements Interaction {

    @Override
    @Step("{0} cierra el popup de contrasena si esta presente")
    public <T extends Actor> void performAs(T actor) {
        try {
            WebDriver driver = Serenity.getDriver();
            // El popup de Chrome es parte del shadow DOM del navegador.
            // Presionar Escape lo cierra sin necesidad de encontrar el boton.
            driver.findElement(By.tagName("body")).sendKeys(
                    org.openqa.selenium.Keys.ESCAPE
            );
            // Pequena pausa para que el popup se cierre
            Thread.sleep(500);
        } catch (Exception ignored) {
            // Si no hay popup, no hacer nada
        }
    }

    public static DismissPasswordPopup ifPresent() {
        return instrumented(DismissPasswordPopup.class);
    }
}
