package co.com.udea.saucedemo.runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * Runner principal del proyecto.
 * <p>
 * Detecta automaticamente todos los archivos .feature ubicados en
 * src/test/resources/features y los conecta con los Step Definitions
 * del paquete co.com.udea.saucedemo.stepdefinitions.
 * <p>
 * Cuando Ana Maria, Juan Pablo y Valentina agreguen sus features y steps,
 * NO necesitan tocar este archivo: basta con que sus .feature queden dentro
 * de la carpeta features y sus clases de steps dentro del paquete stepdefinitions.
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "co.com.udea.saucedemo.stepdefinitions"
)
public class CucumberTestSuite {
}
