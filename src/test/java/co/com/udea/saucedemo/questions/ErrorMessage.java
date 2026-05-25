package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.LoginPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ErrorMessage {

    public static Question<String> text() {
        return Text.of(LoginPage.ERROR_MESSAGE);
    }

    private ErrorMessage() {
        // Clase utilitaria: no se instancia.
    }
}
