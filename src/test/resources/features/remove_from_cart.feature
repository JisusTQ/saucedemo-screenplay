# language: es
Característica: Eliminar productos del carrito de compras en Swag Labs
  Como cliente de la tienda en linea Swag Labs
  Quiero eliminar productos estando dentro de mi carrito de compras
  Para quitar los articulos que ya no deseo comprar antes de pagar

  @carrito @rutaFeliz
  Escenario: Eliminar un producto desde la pagina del carrito
    Dado que "Carlos" esta en la pagina de inicio de Swag Labs
    Cuando intenta iniciar sesion con el usuario "standard_user" y la contraseña "secret_sauce"
    Y agrega el producto "sauce-labs-backpack" al carrito
    Y ve el carrito de compras
    Cuando elimina el producto "sauce-labs-backpack" desde la pagina del carrito
    Entonces el carrito no deberia contener el producto "Sauce Labs Backpack"
    Y el carrito deberia mostrar 0 productos

  @carrito @rutaFeliz
  Escenario: Eliminar solo uno de varios productos del carrito
    Dado que "Carlos" esta en la pagina de inicio de Swag Labs
    Cuando intenta iniciar sesion con el usuario "standard_user" y la contraseña "secret_sauce"
    Y agrega el producto "sauce-labs-backpack" al carrito
    Y agrega el producto "sauce-labs-bike-light" al carrito
    Y ve el carrito de compras
    Cuando elimina el producto "sauce-labs-backpack" desde la pagina del carrito
    Entonces el carrito no deberia contener el producto "Sauce Labs Backpack"
    Y el carrito deberia contener el producto "Sauce Labs Bike Light"
    Y el carrito deberia mostrar 1 producto

  @carrito @rutaExcepcional
  Escenario: Vaciar el carrito eliminando todos los productos
    Dado que "Carlos" esta en la pagina de inicio de Swag Labs
    Cuando intenta iniciar sesion con el usuario "standard_user" y la contraseña "secret_sauce"
    Y agrega el producto "sauce-labs-backpack" al carrito
    Y agrega el producto "sauce-labs-bike-light" al carrito
    Y ve el carrito de compras
    Cuando elimina el producto "sauce-labs-backpack" desde la pagina del carrito
    Y elimina el producto "sauce-labs-bike-light" desde la pagina del carrito
    Entonces el carrito deberia mostrar 0 productos
    Y el badge del carrito no deberia ser visible
