package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * QUESTION: verifica el resultado esperado tras un login exitoso.
 * <p>
 * Devuelve el texto del titulo de la pagina de productos. Si el ingreso fue
 * correcto, ese texto debe ser "Products".
 */
public class InventoryTitle {

    public static Question<String> text() {
        return Text.of(InventoryPage.PAGE_TITLE);
    }

    private InventoryTitle() {
        // Clase utilitaria: no se instancia.
    }
}
