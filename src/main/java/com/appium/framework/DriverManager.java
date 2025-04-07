package com.appium.framework;

import com.appium.framework.config.ConfigManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class DriverManager {

    private static AppiumDriver driver;
    private static AppiumDriverLocalService service;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                // Ruta personalizada donde está ubicado el ejecutable de Appium
                String appiumPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";

                // Inicializar AppiumServiceBuilder con ruta personalizada
                AppiumServiceBuilder builder = new AppiumServiceBuilder()
                        .withAppiumJS(new File(appiumPath))
                        .withIPAddress("127.0.0.1")
                        .usingPort(4723);
                // Inicializar el servicio de Appium desde el código
                service = AppiumDriverLocalService.buildService(builder);
                service.start();

                // Obtener configuraciones desde config.properties
                Properties properties = ConfigManager.loadProperties("config.properties");

                // Inicializar UiAutomator2Options para Android
                UiAutomator2Options options = new UiAutomator2Options()
                        //.setAutoGrantPermissions(true)  // Añade esto
                        .setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(30))  // Tiempo para iniciar el driver
                        .setNewCommandTimeout(Duration.ofSeconds(60))
                        .setPlatformName(properties.getProperty("platformName"))
                        .setDeviceName(properties.getProperty("deviceName"))
                        //.setApp(Paths.get(properties.getProperty("appPath")).toAbsolutePath().toString())
                        .setAppPackage(properties.getProperty("appPackage"))
                        .setAppActivity(properties.getProperty("appActivity"))
                        .setAutomationName(properties.getProperty("automationName"))
                        .setNoReset(Boolean.parseBoolean(properties.getProperty("noReset")));

                // Inicializar AndroidDriver con las opciones
                driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

            } catch (MalformedURLException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

        if (service != null) {
            service.stop();
        }
    }
}
