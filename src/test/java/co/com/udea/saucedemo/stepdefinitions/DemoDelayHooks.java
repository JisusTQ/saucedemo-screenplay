package co.com.udea.saucedemo.stepdefinitions;

import io.cucumber.java.AfterStep;

public class DemoDelayHooks {

    @AfterStep
    public void pausaEntrePasos() {
        long delay = Long.getLong("demo.step.delay", 0L);
        if (delay > 0) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
