# language: es
Característica: Procesar la compra (Checkout) en Swag Labs
Como cliente de la tienda en linea Swag Labs
Quiero completar el formulario de envio y finalizar mi orden
Para visualizar la confirmación exitosa del pedido

@checkout @rutaFeliz
Escenario: Completar una compra de manera exitosa
Dado que "Carlos" esta en la pagina de inicio de Swag Labs
Cuando intenta iniciar sesion con el usuario "standard_user" y la contrasena "secret_sauce"
Y agrega el producto "sauce-labs-backpack" al carrito
Y procede a realizar el pago con los datos "Carlos", "Toro" y "05001"
Entonces deberia ver el mensaje de confirmacion "Thank you for your order!"

@checkout @rutaExcepcional
Escenario: Intentar completar una compra sin llenar todos los campos del formulario de envio
Dado que "Carlos" esta en la pagina de inicio de Swag Labs
Cuando intenta iniciar sesion con el usuario "standard_user" y la contrasena "secret_sauce"
Y agrega el producto "sauce-labs-backpack" al carrito
Y procede a realizar el pago con los datos "", "Toro" y "05001"
Entonces deberia ver el mensaje de error en el checkout "Error: First Name is required"