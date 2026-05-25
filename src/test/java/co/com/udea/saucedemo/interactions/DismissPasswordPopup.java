package co.com.udea.saucedemo.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.Serenity;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class DismissPasswordPopup implements Interaction {

    @Override
    @Step("{0} cierra el popup de contrasena si esta presente")
    public <T extends Actor> void performAs(T actor) {
        try {
            WebDriver driver = Serenity.getDriver();
            driver.findElement(By.tagName("body")).sendKeys(
                    org.openqa.selenium.Keys.ESCAPE
            );
            Thread.sleep(500);
        } catch (Exception ignored) {
        }
    }

    public static DismissPasswordPopup ifPresent() {
        return instrumented(DismissPasswordPopup.class);
    }
}
