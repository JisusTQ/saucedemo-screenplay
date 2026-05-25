# Automatización de Pruebas E2E — Swag Labs

**Calidad de Software · Universidad de Antioquia · 2026-1**

Suite de pruebas **End-to-End** automatizadas sobre la tienda en línea [Swag Labs](https://www.saucedemo.com/), construida con el **patrón Screenplay** sobre **Serenity BDD + Cucumber (Gherkin) + JUnit 5**.

---

## Contenido del proyecto

La suite cubre el flujo completo de un cliente en la tienda, con **ruta feliz y caminos excepcionales** en cada característica:

| Característica | Escenarios | Rutas |
|---|---|---|
| Inicio de sesión | 2 | Feliz (credenciales válidas) + Excepcional (usuario bloqueado) |
| Agregar al carrito | 3 | Uno / varios productos + eliminar |
| Ver carrito | 3 | Con uno / varios productos + carrito vacío |
| Eliminar del carrito | 3 | Uno de varios / vaciar todo |
| Checkout (pago) | 2 | Feliz (orden confirmada) + Excepcional (validación de formulario) |
| **Total** | **13** | |

---

## Requisitos previos

- **JDK 17 o superior** (`java -version`).
- **Apache Maven** (`mvn -version`).
- **Google Chrome** instalado. El driver se descarga solo (Selenium Manager); no hay que configurarlo.

## Cómo ejecutar las pruebas

Desde la raíz del proyecto:

```bash
mvn clean verify
```

La primera ejecución descarga las dependencias (necesita internet). Al terminar genera el reporte de Serenity.

### Modo sustentación: pausa entre pasos (Delay)

Para que durante la exposición se pueda observar cada acción con detenimiento, la suite incluye una **pausa configurable entre paso y paso**. Se activa por línea de comandos, en milisegundos:

```bash
mvn clean verify -Ddemo.step.delay=1500
```

Sin ese parámetro, la suite corre a velocidad normal (ideal para integración continua). La pausa está centralizada en un único hook (`DemoDelayHooks`), en vez de repartir `Thread.sleep` por el código.

## Cómo ver el reporte de Serenity

Abrir en el navegador:

```
target/site/serenity/index.html
```

---

## Arquitectura: el patrón Screenplay

El actor **Carlos** ejecuta las pruebas. El flujo va de lo abstracto (negocio) a lo concreto (técnico):

1. **Feature (Gherkin):** describe el escenario en lenguaje del negocio, en español.
2. **Step Definitions:** traducen cada paso del Gherkin a acciones del actor.
3. **Tasks:** *qué* hace el actor en términos del negocio (p. ej. `Login`, `AddProductToCart`, `ProcessCheckout`).
4. **Interactions:** *cómo* lo hace a bajo nivel — "la menuda" (p. ej. `EnterCredentials`, `ClickAddToCart`).
5. **UI / Targets:** *dónde* están los elementos, mediante selectores estables (`data-test`).
6. **Questions:** *verifican* el resultado esperado (p. ej. `InventoryTitle`, `CartBadgeCount`, `CheckoutMessage`).

### Estructura de carpetas

```
src/test/
├── java/co/com/udea/saucedemo/
│   ├── runners/          CucumberTestSuite — detecta y corre todos los .feature
│   ├── ui/               PageObjects con los Targets (selectores)
│   ├── interactions/     Interactions — el detalle de bajo nivel ("la menuda")
│   ├── tasks/            Tasks — las acciones en términos del negocio
│   ├── questions/        Questions — verificación de resultados
│   └── stepdefinitions/  Pegamento Gherkin <-> Screenplay + hook de pausa
└── resources/
    ├── features/         Escenarios en Gherkin (español)
    ├── serenity.conf     Configuración del navegador y reportes
    └── junit-platform.properties
```

---

## Stack técnico

| Herramienta | Versión | Rol |
|---|---|---|
| Serenity BDD | 5.3.7 | Framework de automatización + reportes |
| Cucumber | 7.34.2 | Gherkin / BDD |
| JUnit | 5 (Platform) | Motor de ejecución |
| Selenium (vía Serenity) | — | Driver del navegador |
| Maven | 3.9+ | Construcción y dependencias |

---

## Usuarios de prueba de Swag Labs

- `standard_user` — usuario normal.
- `locked_out_user` — bloqueado (genera error de login; usado en la ruta excepcional).
- Contraseña para todos: `secret_sauce`.

---

## Equipo

Ana María · Juan Pablo · Valentina · Jesús
Docente: Robinson Coronado G. — Facultad de Ingenierías, Universidad de Antioquia.
