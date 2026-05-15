# Conclusiones - Automatización E2E

## Cobertura lograda
Se refactorizó el flujo E2E para cubrir una compra completa en SauceDemo, incluyendo autenticación, selección de dos productos, validación de carrito, carga de datos de checkout y confirmación final de la orden.

## Hallazgos
- El flujo positivo permite evidenciar una automatización de negocio completa, no solo autenticación.
- Los escenarios negativos validan bloqueo de usuario e ingreso de credenciales inválidas antes de la compra.
- Los datos se encuentran desacoplados en JSON, lo que permite ampliar perfiles y productos sin cambiar el feature.

## Recomendaciones
- Agregar integración CI/CD para publicar reportes Serenity como artefactos.
- Ampliar la suite con validaciones de ordenamiento, remoción de productos y checkout con campos obligatorios vacíos.
- Mantener tags por criticidad: `@smoke`, `@regression`, `@negative`.
