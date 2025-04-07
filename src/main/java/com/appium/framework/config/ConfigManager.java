package com.appium.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties = new Properties();

    /**
     * Carga propiedades desde el archivo config.properties o cualquier otro especificado.
     * @param fileName El nombre del archivo de configuración.
     * @return Propiedades cargadas.
     */
    public static Properties loadProperties(String fileName) {
        try (FileInputStream input = new FileInputStream("src/main/resources/" + fileName)) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de configuración: " + fileName);
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * Obtiene el valor de una propiedad específica.
     * Prioriza valores pasados por System Property, luego el archivo de configuración.
     * @param key La clave de la propiedad.
     * @return El valor de la propiedad.
     */
    public static String getProperty(String key) {
        // Prioriza el valor pasado por System Property antes de usar config.properties
        return System.getProperty(key, properties.getProperty(key));
    }
}
