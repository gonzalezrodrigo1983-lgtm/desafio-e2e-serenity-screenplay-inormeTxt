# Desafío Técnico - Automatización E2E con Serenity BDD + Screenplay

## Objetivo
Automatizar un flujo E2E completo de compra usando una URL pública de práctica QA:

- URL base: `https://www.saucedemo.com/`
- Flujo cubierto: login, selección de 2 productos, carrito, checkout y confirmación de compra.
- Flujo negativo adicional: validación de errores de autenticación.

## Stack técnico
- Java 17, compatible con JDK 11/17.
- Maven 3.9.1 compatible.
- Serenity BDD 4.x.
- Cucumber.
- Screenplay Pattern.
- Datos parametrizados en JSON.

## Estructura relevante
```text
src/test/resources/features/compra_e2e.feature
src/test/resources/data/purchase-data.json
src/test/java/com/bancaecuador/e2e/tasks
src/test/java/com/bancaecuador/e2e/questions
src/test/java/com/bancaecuador/e2e/ui
src/test/java/com/bancaecuador/e2e/models
docs/conclusiones.md
docs/INFORME_CIERRE_DESAFIO.txt
docs/analisis-reportes.md
```


## Informe de cierre TXT
Se agrega el archivo `docs/INFORME_CIERRE_DESAFIO.txt` como informe de cierre del desafio, incluyendo objetivo, alcance cubierto, refactorizacion aplicada, evidencias, resultado del cierre, observaciones y conclusion final.

## Ejecutar pruebas
Ejecución estándar headless:
```bash
mvn clean verify
```

Ejecución visible en navegador:
```bash
mvn clean verify -Dheadless.mode=false
```

Ejecución por tags:
```bash
mvn clean verify -Dcucumber.filter.tags="@compra"
```

## Reportes generados
- Serenity HTML: `target/site/serenity/index.html`
- Cucumber JSON: `target/cucumber-reports/e2e-cucumber.json`
- Cucumber HTML: `target/cucumber-reports/e2e-cucumber-html/index.html`

El repositorio incluye reportes físicos de referencia para revisión inicial. Al ejecutar localmente, Maven los regenera en las mismas rutas.

## Cobertura funcional
| Caso | Tipo | Estado |
|---|---|---|
| Login exitoso con usuario estándar | Positivo | Cubierto |
| Agregar 2 productos al carrito | Positivo | Cubierto |
| Visualizar carrito y validar productos | Positivo | Cubierto |
| Completar formulario de checkout | Positivo | Cubierto |
| Confirmar orden de compra | Positivo | Cubierto |
| Login bloqueado o inválido | Negativo | Cubierto |

## Decisiones de diseño
- Se usa Screenplay para separar tareas, preguntas, UI y modelos.
- Los datos de usuario, productos y checkout viven en `purchase-data.json`.
- Las aserciones validan resultados de negocio visibles para el usuario: productos en carrito, total de checkout y mensaje final.
