package co.com.udea.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LogoutPage {

    public static final Target BURGER_MENU =
            Target.the("menu hamburguesa").locatedBy("#react-burger-menu-btn");

    public static final Target LOGOUT_LINK =
            Target.the("enlace de logout").locatedBy("#logout_sidebar_link");

    private LogoutPage() {}
}
