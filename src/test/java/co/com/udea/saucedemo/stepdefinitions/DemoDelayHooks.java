package co.com.udea.saucedemo.stepdefinitions;

import io.cucumber.java.AfterStep;

/**
 * HOOK GLOBAL DE PAUSA ENTRE PASOS.
 * <p>
 * El taller (criterio de Socializacion) pide usar un <b>Delay / sleep entre paso
 * y paso</b> para que, durante la sustentacion, se pueda observar cada accion de
 * la prueba con detenimiento.
 * <p>
 * En lugar de regar {@code Thread.sleep(...)} por todo el codigo (mala practica),
 * centralizamos la pausa en un unico lugar y la hacemos <b>configurable</b> por
 * propiedad del sistema {@code demo.step.delay} (en milisegundos):
 * <ul>
 *   <li>Para la sustentacion:  {@code mvn clean verify -Ddemo.step.delay=1500}</li>
 *   <li>Para correr rapido/CI:  {@code mvn clean verify}  (sin pausa, valor 0)</li>
 * </ul>
 * Asi cumplimos el requisito sin sacrificar buenas practicas ni velocidad en CI.
 */
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
