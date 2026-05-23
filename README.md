# Automatización Swag Labs — Calidad de Software (UdeA)

Pruebas E2E automatizadas con el **patrón Screenplay** sobre **Serenity BDD + Cucumber (Gherkin) + JUnit 5**.

Sitio bajo prueba: **https://www.saucedemo.com/** (Swag Labs).

---

## Parte incluida en este esqueleto (Jesús): arquitectura base + Login

Este repositorio ya trae el proyecto montado y un flujo completo de **inicio de sesión** funcionando, que sirve como ejemplo de las capas del patrón para que el resto del equipo agregue las suyas.

---

## Requisitos previos

- **JDK 17 o superior** (Serenity 5.3.7 lo exige). Verificar con `java -version`.
- **Apache Maven** instalado. Verificar con `mvn -version`.
- **Google Chrome** instalado. El driver se descarga solo (Selenium Manager); no hay que configurar nada.

## Cómo ejecutar las pruebas

Desde la raíz del proyecto:

```bash
mvn clean verify
```

Esto ejecuta los escenarios y, al terminar, genera el reporte de Serenity.

## Cómo ver el reporte

Abrir en el navegador:

```
target/site/serenity/index.html
```

---

## Estructura del proyecto

```
saucedemo-screenplay/
├── pom.xml                         # Dependencias y plugins (Serenity, Cucumber, reportes)
└── src/test/
    ├── java/co/com/udea/saucedemo/
    │   ├── runners/
    │   │   └── CucumberTestSuite.java   # Detecta y corre todos los .feature
    │   ├── ui/
    │   │   ├── LoginPage.java           # Selectores de la pantalla de login
    │   │   └── InventoryPage.java       # Selectores de la pantalla de productos
    │   ├── interactions/
    │   │   └── EnterCredentials.java    # Interaction: el detalle ("la menuda")
    │   ├── tasks/
    │   │   └── Login.java               # Task: la acción en términos del negocio
    │   ├── questions/
    │   │   ├── InventoryTitle.java      # Question: ¿el login fue exitoso?
    │   │   └── ErrorMessage.java        # Question: ¿qué error mostró?
    │   └── stepdefinitions/
    │       └── LoginStepDefinitions.java # Pegamento Gherkin <-> Screenplay
    └── resources/
        ├── features/
        │   └── login.feature            # Escenarios en Gherkin (español)
        ├── serenity.conf                # Configuración del navegador y reportes
        └── junit-platform.properties    # Configuración del reporter de Serenity
```

---

## Las capas del patrón Screenplay (para la sustentación)

El actor **Carlos** ejecuta la prueba. El flujo va de lo abstracto a lo concreto:

1. **Feature (Gherkin):** describe el escenario en lenguaje del negocio.
2. **Step Definitions:** traducen cada paso del Gherkin a acciones del actor.
3. **Task** (`Login`): *qué* hace el actor en términos del negocio ("iniciar sesión").
4. **Interaction** (`EnterCredentials`): *cómo* lo hace a bajo nivel — "la menuda".
5. **UI / Targets** (`LoginPage`, `InventoryPage`): *dónde* están los elementos (selectores).
6. **Question** (`InventoryTitle`, `ErrorMessage`): *verifica* el resultado esperado.

Escenarios cubiertos en esta parte:
- **Ruta feliz:** `standard_user` / `secret_sauce` → llega a la página de productos.
- **Ruta excepcional:** `locked_out_user` → muestra el mensaje de usuario bloqueado.

---

## Para el equipo (al unir mañana)

- Cada quien deja sus `.feature` dentro de `resources/features/` y sus clases de steps dentro del paquete `stepdefinitions`. **No hay que tocar el runner.**
- Mantener los mismos paquetes (`tasks`, `interactions`, `questions`, `ui`, `stepdefinitions`) y un **único actor** con el mismo nombre.
- Reutilizar `EnterCredentials`/`Login` y los Targets ya creados cuando se necesite estar logueado antes de operar el carrito.

### Usuarios de prueba de Swag Labs (útiles para más escenarios)
- `standard_user` — usuario normal.
- `locked_out_user` — bloqueado (genera error de login).
- `problem_user`, `performance_glitch_user` — útiles para escenarios creativos.
- Contraseña para todos: `secret_sauce`.
