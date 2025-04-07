Feature: Validación de Login en Facebook

  Scenario: Login exitoso con credenciales válidas
    Given el usuario abre la aplicación de Facebook
    When el usuario ingresa el correo "testuser@gmail.com"
    And el usuario ingresa la contraseña "password123"
    And el usuario hace clic en el botón de login
    Then el usuario debería ver la pantalla principal de Facebook

  Scenario: Login fallido con credenciales inválidas
    Given el usuario abre la aplicación de Facebook
    When el usuario ingresa el correo "testuser@gmail.com"
    And el usuario ingresa la contraseña "wrongpassword"
    And el usuario hace clic en el botón de login
    Then el usuario debería ver un mensaje de error
