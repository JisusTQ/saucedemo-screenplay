# language: es
Característica: Agregar productos al carrito en Swag Labs
  Como cliente de la tienda en linea Swag Labs
  Quiero agregar productos a mi carrito de compras
  Para poder proceder con la compra de los articulos que me interesan

  @carrito @rutaFeliz
  Escenario: Agregar un producto al carrito exitosamente
    Dado que "Carlos" esta en la pagina de inicio de Swag Labs
    Cuando intenta iniciar sesion con el usuario "standard_user" y la contrasena "secret_sauce"
    Y agrega el producto "sauce-labs-backpack" al carrito
    Entonces el badge del carrito deberia mostrar "1"
    Y el carrito deberia contener el producto "Sauce Labs Backpack"

  @carrito @rutaFeliz
  Escenario: Agregar multiples productos al carrito
    Dado que "Carlos" esta en la pagina de inicio de Swag Labs
    Cuando intenta iniciar sesion con el usuario "standard_user" y la contrasena "secret_sauce"
    Y agrega el producto "sauce-labs-backpack" al carrito
    Y agrega el producto "sauce-labs-bike-light" al carrito
    Entonces el badge del carrito deberia mostrar "2"
    Y el carrito deberia contener el producto "Sauce Labs Backpack"

  @carrito @rutaExcepcional
  Escenario: Eliminar un producto previamente agregado al carrito
    Dado que "Carlos" esta en la pagina de inicio de Swag Labs
    Cuando intenta iniciar sesion con el usuario "standard_user" y la contrasena "secret_sauce"
    Y agrega el producto "sauce-labs-backpack" al carrito
    Cuando elimina el producto "sauce-labs-backpack" del carrito
    Entonces el badge del carrito no deberia ser visible
