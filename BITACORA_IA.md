# Bitácora de uso de IA — Patrón Prototype

Aprendices: Katalina Ruiz / ______________________
Ficha: 3409871  Fecha de inicio: 23/11/2026

> La bitácora es evidencia del ítem 18 de la lista de chequeo. Regístralo **todo**, también las respuestas de la IA que estaban mal.
> Nunca pegues en una IA contraseñas, tokens, datos personales reales ni código que no tengas permiso de compartir.

## 1. Predicción sin IA (máx. 20 minutos)

Antes de abrir cualquier IA, lee el README y el código. Escribe aquí qué errores crees que hay y por qué.

| # | Archivo y línea | ¿Qué creo que está mal? | ¿Qué regla de negocio rompe? |
|---|---|---|---|
| 1 || | |
| 2 | | | |
| 3 | | | |
Antes de ejecutar las pruebas no había identificado ningún error en el código. Revisé el proyecto,
pero todavía no tenía claro qué partes podían estar fallando.

### Resultados de las pruebas iniciales
- 4 pruebas ejecutadas.
- 3 pruebas pasaron.
- 1 prueba falló.
- La prueba laCopiaTieneLosMismosValores() falló porque esperaba un precio de 18000, pero obtuvo null.

### Resultados después de agregar las pruebas
- Se ejecutaron 6 pruebas.
- 3 pruebas pasaron y 3 fallaron.
- Error 1: la copia no conserva el precio.
- Error 2: las etiquetas de la copia afectan al original.
- Error 3: el registro devuelve el mismo objeto.

## 2. Registro de interacciones con IA

Copia una fila por cada consulta importante.

| # | Herramienta (ChatGPT / Gemini / DeepSeek / Copilot / otra) | Prompt (resumen o enlace) | ¿Qué respondió? | ¿Era correcto? ¿Cómo lo verifiqué? | ¿Lo usé? (sí / no / modificado) |
|---|---|---|---|---|---|
| 1 | | | | | |
| 2 | | | | | |
| 3 | | | | | |

## 3. Jurado de IAs

Consulté ChatGPT, Gemini y Copilot con el mismo prompt. Las tres encontraron los errores del patrón Prototype: 
el precio no se copia, las etiquetas se comparten y el registro devuelve el mismo objeto.
Las tres coincidieron en los problemas, pero Copilot propuso una prueba que no comprobaba correctamente 
si las etiquetas eran independientes.
Comparé las respuestas con las pruebas que ejecuté en IntelliJ. Decidí conservar las
pruebas que realmente demostraban los errores.

Envía el **mismo prompt** a tres herramientas distintas y compara.

| Pregunta enviada | ChatGPT | Gemini | DeepSeek | ¿Quién acertó? ¿En qué discreparon? |
|---|---|---|---|---|
| | | | | |

## 4. Errores encontrados y corregidos

| # | Error | Prueba que lo demuestra (nombre del método de prueba) | Commit de la corrección | ¿Lo encontré yo, la IA o ambos? |
|---|---|---|---|---|
| 1 | | | | |
| 2 | | | | |
| 3 | | | | |

## 5. Lo que la IA hizo mal o no vio

Describe por lo menos un caso en que la IA se equivocó, inventó algo o propuso un cambio peligroso. ¿Cómo te diste cuenta?

## 6. Reflexión final (5 a 10 líneas)
R/= En esta actividad aprendí cómo funciona el patrón Prototype y para qué sirve.
La inteligencia artificial me ayudó a entender el código y encontrar los errores más rápido.
Al principio no sabía qué estaba fallando, pero con las pruebas pude identificar los problemas.
Utilicé ChatGPT, Gemini y Copilot para comparar sus respuestas.
No acepté todas las sugerencias sin revisarlas, porque algunas pruebas no demostraban bien el error.
También aprendí a corregir el código y comprobar que funcionara con JUnit 5.
Ahora entiendo que las copias deben ser independientes para no afectar al producto original.

¿Qué parte del trabajo aceleró la IA? ¿En qué momento decidiste **no** usarla y por qué? ¿Qué aprendiste del patrón que no sabías antes?
### ¿Qué parte del trabajo aceleró la IA?
La IA me ayudó a encontrar los errores más rápido, entender por qué fallaba el código y saber cómo podía corregirlos.

### ¿En qué momento decidiste no usarla y por qué?
Cuando tuve que comprobar si las respuestas eran correctas, preferí ejecutar las pruebas en IntelliJ, 
porque no quería confiar solamente en lo que decía la IA.

### ¿Qué aprendiste del patrón que no sabías antes?
Aprendí que el patrón Prototype sirve para crear copias de objetos y que estas deben ser independientes 
para que los cambios de una no afecten a la otra.




## 7. Seguridad

En el código original había un problema porque los productos compartían información. Si otra clase modificaba el precio o 
las etiquetas de un producto,
podía afectar a otros productos creados desde la misma plantilla.
Esto podía causar cambios incorrectos en los datos. Para solucionarlo, 
hicimos que cada producto tenga su propia copia independiente.
