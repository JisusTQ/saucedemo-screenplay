# language: es
Característica: Ver el carrito de compras en Swag Labs
  Como cliente de la tienda en linea Swag Labs
  Quiero ver el contenido de mi carrito de compras
  Para revisar los productos que agregue antes de proceder con la compra

  @carrito @rutaFeliz
  Escenario: Ver el carrito con un producto agregado
    Dado que "Carlos" esta en la pagina de inicio de Swag Labs
    Cuando intenta iniciar sesion con el usuario "standard_user" y la contrasena "secret_sauce"
    Y agrega el producto "sauce-labs-backpack" al carrito
    Y ve el carrito de compras
    Entonces deberia ver la pagina del carrito de compras
    Y el carrito deberia mostrar 1 producto
    Y el carrito deberia contener el producto "Sauce Labs Backpack"

  @carrito @rutaFeliz
  Escenario: Ver el carrito con multiples productos agregados
    Dado que "Carlos" esta en la pagina de inicio de Swag Labs
    Cuando intenta iniciar sesion con el usuario "standard_user" y la contrasena "secret_sauce"
    Y agrega el producto "sauce-labs-backpack" al carrito
    Y agrega el producto "sauce-labs-bike-light" al carrito
    Y ve el carrito de compras
    Entonces deberia ver la pagina del carrito de compras
    Y el carrito deberia mostrar 2 productos
    Y el carrito deberia contener el producto "Sauce Labs Bike Light"

  @carrito @rutaExcepcional
  Escenario: Ver el carrito de compras vacio
    Dado que "Carlos" esta en la pagina de inicio de Swag Labs
    Cuando intenta iniciar sesion con el usuario "standard_user" y la contrasena "secret_sauce"
    Y ve el carrito de compras
    Entonces deberia ver la pagina del carrito de compras
    Y el carrito deberia mostrar 0 productos
