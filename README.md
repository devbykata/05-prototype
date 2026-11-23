# MercaSENA · Patrón Prototype (Creacional)

**Dominio:** Plantillas de productos para crear referencias nuevas

## Contexto

Los vendedores de MercaSENA crean productos nuevos a partir de **plantillas**. Por ejemplo, la plantilla "Café de origen" ya trae etiquetas (`orgánico`, `colombiano`) y atributos (`presentación: 500 g`). En lugar de construir cada producto desde cero, se **clona** la plantilla con el patrón **Prototype** y luego se ajusta.

Clases principales:

- `PlantillaProducto`: prototipo con nombre, precio, etiquetas y atributos. Tiene el método `copiar()`.
- `RegistroPlantillas`: guarda prototipos por clave y entrega copias nuevas.

## Reglas de negocio

1. `copiar()` produce un objeto **independiente** con los mismos valores: nombre, precio, etiquetas y atributos.
2. Modificar la copia (su precio, sus etiquetas o sus atributos) **nunca** modifica el original, y al revés.
3. El registro guarda su propia copia al registrar una plantilla. Cada llamada a `crear(clave)` entrega un objeto **nuevo**: dos productos creados desde la misma plantilla no comparten estado.
4. `crear` con una clave que no existe lanza `IllegalArgumentException`.
5. `getEtiquetas()` y `getAtributos()` devuelven vistas de solo lectura. Para cambiar el producto se usan los métodos `agregarEtiqueta` y `ponerAtributo`.

## Tu misión

Este proyecto implementa el patrón **Prototype** dentro de la tienda en línea **MercaSENA**. El código *compila*, pero tiene **errores sembrados**: algunos los detectan las pruebas que ya existen y otros **no**. Tu trabajo es encontrarlos todos, demostrarlos con pruebas y corregirlos con ayuda de la IA, sin perder el control técnico.

> La fuente de verdad son las **reglas de negocio** de este README. La IA no las conoce si no se las das.

## Protocolo de trabajo (obligatorio)

1. **Prepara el repositorio.** Crea un repositorio en GitHub con este proyecto y haz el primer commit sin cambios: `git commit -m "chore: estado inicial"`.
2. **Predice sin IA (20 min).** Lee este README y el código. Escribe tus hipótesis en `BITACORA_IA.md`, sección 1.
3. **Ejecuta las pruebas.** Corre `mvn test` o las pruebas desde IntelliJ / Eclipse. Anota cuáles fallan.
4. **Demuestra cada error con una prueba.** Por cada error que encuentres, incluidos los que las pruebas actuales no detectan, escribe primero una prueba que **falle**. Haz commit: `test: demuestra <error>`.
5. **Consulta al jurado de IAs.** Envía el mismo prompt a ChatGPT, Gemini y DeepSeek. Usa el prompt de 5 piezas: contexto, tarea, restricciones, formato y criterio de verificación. Registra en la bitácora en qué coincidieron y en qué no.
6. **Corrige.** Aplica la corrección que **tú** entiendes y puedes explicar. La prueba debe pasar. Haz commit: `fix: corrige <error>`.
7. **Refactoriza con IA.** Pide a la IA una mejora de legibilidad que no cambie el comportamiento. Todas las pruebas deben seguir en verde. Haz commit: `refactor: ...`.
8. **Revisa la seguridad.** Pregúntate qué podría hacer un usuario malicioso con este código y anota tu respuesta en la bitácora.
9. **Prepara la defensa.** El instructor te pedirá explicar, **sin IA**, cualquier línea que hayas cambiado.

## Cómo ejecutar

```bash
mvn test
```

Requisitos: JDK 17 o superior y Maven 3.9 o superior, o el Maven que trae IntelliJ IDEA o Eclipse.

## Qué NO hacer

- No borres ni debilites pruebas para que pasen.
- No pegues el proyecto completo en una IA sin explicarle las reglas de negocio.
- No aceptes una corrección que no sabes explicar.

## Referencia del patrón

- https://refactoring.guru/es/design-patterns/prototype
