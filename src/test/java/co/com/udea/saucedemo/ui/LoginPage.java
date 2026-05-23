package co.com.udea.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Mapa de elementos (PageObject estilo Screenplay) de la pagina de login de Swag Labs.
 * <p>
 * Aqui solo se declaran los "Targets": el nombre legible del elemento + su selector.
 * Swag Labs usa selectores muy estables (ids y atributos data-test), por eso es
 * el sitio mas confiable para automatizar.
 */
public class LoginPage {

    /** URL de la pagina de inicio de Swag Labs. */
    public static final String URL = "https://www.saucedemo.com/";

    public static final Target USERNAME_FIELD =
            Target.the("campo de usuario").locatedBy("#user-name");

    public static final Target PASSWORD_FIELD =
            Target.the("campo de contrasena").locatedBy("#password");

    public static final Target LOGIN_BUTTON =
            Target.the("boton de ingreso").locatedBy("#login-button");

    public static final Target ERROR_MESSAGE =
            Target.the("mensaje de error").locatedBy("[data-test='error']");

    private LoginPage() {
        // Clase de constantes: no se instancia.
    }
}
