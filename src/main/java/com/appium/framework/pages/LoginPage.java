package com.appium.framework.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"listItemTitle\" and @text=\"Login Screen\"]")
    private WebElement loginScreen;

    @AndroidFindBy(accessibility = "username")
    private WebElement inputFields1;

    @AndroidFindBy(accessibility = "password")
    private WebElement inputFields2;  // Usamos WebElement

    @AndroidFindBy(accessibility = "loginBtn")
    private WebElement loginButton;

    @FindBy(id = "com.facebook.katana:id/login_error")
    private WebElement errorMessage;

    public LoginPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
        loginScreen.click();
    }

    // Ingresar usuario/correo en el primer EditText
    public void enterUsername(String username) {
        try {
            inputFields1.clear();
            inputFields1.sendKeys(username);
            System.out.println("Usuario ingresado: " + username);
        } catch (Exception e) {
            System.err.println("Error al ingresar el usuario: " + e.getMessage());
        }
    }

    // Ingresar contraseña en el segundo EditText
    public void enterPassword(String password) {
        try {
            inputFields2.sendKeys(password);
            System.out.println("Contraseña ingresada.");
        } catch (Exception e) {
            System.err.println("Error al ingresar la contraseña: " + e.getMessage());
        }
    }

    // Hacer clic en el botón de login
    public void clickLogin() {
        try {
            loginButton.click();
            System.out.println("Se hizo clic en el botón de login.");
        } catch (Exception e) {
            System.err.println("Error al hacer clic en el botón de login: " + e.getMessage());
        }
    }

    // Verificar si el mensaje de error se muestra
    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            System.err.println("Error al verificar mensaje de error: " + e.getMessage());
            return false;
        }
    }
}
