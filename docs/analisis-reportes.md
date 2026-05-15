# Análisis de Reportes - E2E

## Reportes incluidos
- `target/site/serenity/index.html`: reporte ejecutivo Serenity.
- `target/cucumber-reports/e2e-cucumber.json`: evidencia Cucumber JSON para integraciones.
- `target/cucumber-reports/e2e-cucumber-html/index.html`: reporte HTML Cucumber.

## Interpretación esperada
La ejecución debe finalizar con escenarios exitosos para el flujo positivo de compra y para las validaciones negativas de login. Cualquier error en selectores, disponibilidad del sitio público o lentitud debe revisarse en las capturas y trazas generadas por Serenity.
