/*package com.appium.framework.base;

import com.appium.framework.DriverManager;
import com.appium.framework.reports.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import java.lang.reflect.Method;

public class BaseTest {

    protected static AppiumDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        System.out.println("Iniciando el servicio de Appium...");
        extent = ExtentManager.getInstance();
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Iniciando el driver de Appium...");
        driver = DriverManager.getDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method) {
        // Crear un nuevo test en el reporte para cada método
        test = extent.createTest(method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("Finalizando el test...");
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        System.out.println("Cerrando el driver...");
        DriverManager.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        System.out.println("Finalizando el servicio de Appium...");
        extent.flush();
    }
}*/
