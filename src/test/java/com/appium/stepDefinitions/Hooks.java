package com.appium.stepDefinitions;

import com.appium.framework.DriverManager;
import com.appium.framework.reports.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static ExtentReports extent;
    public static ExtentTest scenarioTest;
    static AppiumDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        // Inicializamos ExtentReports una sola vez
        if (extent == null) {
            extent = ExtentManager.getInstance();
        }

        // Creamos un test para cada Escenario de Cucumber
        scenarioTest = extent.createTest(scenario.getName());

        // Iniciamos el driver
        driver = DriverManager.getDriver();
        scenarioTest.info("Driver iniciado para escenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        scenarioTest.info("Finalizando escenario: " + scenario.getName());

        // Si se desea, cerrar el driver después de cada escenario
        if (driver != null) {
            DriverManager.quitDriver();
            scenarioTest.info("Driver cerrado.");
        }

        // Flush del reporte para guardar los resultados
        extent.flush();
    }
}
