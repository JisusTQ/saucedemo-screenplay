package co.com.udea.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Mapa de elementos del menu de navegacion lateral (burger menu).
 * Usado para hacer logout y limpiar el estado entre escenarios.
 */
public class LogoutPage {

    public static final Target BURGER_MENU =
            Target.the("menu hamburguesa").locatedBy("#react-burger-menu-btn");

    public static final Target LOGOUT_LINK =
            Target.the("enlace de logout").locatedBy("#logout_sidebar_link");

    private LogoutPage() {}
}
