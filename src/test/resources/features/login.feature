# language: es
Característica: Inicio de sesión en Swag Labs
  Como cliente de la tienda en línea Swag Labs
  Quiero iniciar sesión en la plataforma
  Para poder acceder al catálogo de productos

  @login @rutaFeliz
  Escenario: Inicio de sesión exitoso con credenciales válidas
    Dado que "Carlos" esta en la pagina de inicio de Swag Labs
    Cuando intenta iniciar sesion con el usuario "standard_user" y la contrasena "secret_sauce"
    Entonces deberia ver la pagina de productos

  @login @rutaExcepcional
  Escenario: Inicio de sesión fallido con un usuario bloqueado
    Dado que "Carlos" esta en la pagina de inicio de Swag Labs
    Cuando intenta iniciar sesion con el usuario "locked_out_user" y la contrasena "secret_sauce"
    Entonces deberia ver el mensaje de error "Sorry, this user has been locked out"
