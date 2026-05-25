package co.com.udea.saucedemo.questions;

import co.com.udea.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class InventoryTitle {

    public static Question<String> text() {
        return Text.of(InventoryPage.PAGE_TITLE);
    }

    private InventoryTitle() {
    }
}
