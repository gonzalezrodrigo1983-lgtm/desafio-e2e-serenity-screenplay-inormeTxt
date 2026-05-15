# language: es
Característica: Compra E2E en sitio público QA SauceDemo
  Como QA Automation Engineer
  Quiero automatizar un flujo de compra completo de extremo a extremo
  Para cubrir selección de productos, carrito, checkout y confirmación de compra con Serenity Screenplay

  @e2e @compra @smoke
  Escenario: Compra exitosa de dos productos con datos parametrizados en JSON
    Dado que Rodrigo ingresa a la tienda pública SauceDemo
    Cuando inicia sesión con el perfil de compra "standard_checkout"
    Y agrega los productos parametrizados al carrito
    Entonces debe visualizar el carrito con los productos seleccionados
    Cuando completa el checkout con los datos parametrizados
    Y confirma la orden de compra
    Entonces debe visualizar la confirmación exitosa de la compra

  @e2e @login @negative
  Esquema del escenario: Validación de login negativo antes del flujo de compra
    Dado que Rodrigo ingresa a la tienda pública SauceDemo
    Cuando inicia sesión con el perfil de compra "<perfil>"
    Entonces debe visualizar el error de autenticación esperado

    Ejemplos:
      | perfil            |
      | locked_out_user   |
      | invalid_user      |
