package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.LoginPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * QUESTION: verifica el resultado esperado tras un login fallido.
 * <p>
 * Devuelve el texto del mensaje de error que muestra Swag Labs (por ejemplo,
 * cuando se usa el usuario bloqueado "locked_out_user").
 */
public class ErrorMessage {

    public static Question<String> text() {
        return Text.of(LoginPage.ERROR_MESSAGE);
    }

    private ErrorMessage() {
        // Clase utilitaria: no se instancia.
    }
}
