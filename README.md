# El Despertar del Héroe

## Descripción del proyecto

El Despertar del Héroe es un videojuego de aventura textual desarrollado en Java, donde el jugador deberá enfrentarse a tres enemigos para conseguir salvar el reino de Eldoria.

Este proyecto se ha realizado para trabajar los contenidos de Programación, Lenguajes de Marcas y Entornos de Desarrollo de 1.º de Desarrollo de Aplicaciones Multiplataforma (DAM).

## Funcionamiento del juego

Al ejecutar el programa, aparece un menú principal con cuatro opciones:

1. Nueva partida.
2. Consultar ranking.
3. Ayuda.
4. Salir.

Al comenzar una partida, el jugador introduce su nombre y elige entre tres personajes:

- **Mago:** 75 puntos de vida, bastón mágico y daño de 15 a 25.
- **Héroe:** 100 puntos de vida, espada y daño de 10 a 20.
- **Arquero:** 85 puntos de vida, arco y daño de 12 a 22.

Durante la aventura tendrá que superar tres combates consecutivos contra un Goblin, un Orco y un Dragón Oscuro.

En cada turno podrá atacar, utilizar una poción de vida, consultar su inventario o huir del combate.

Los ataques tienen una probabilidad del 30 % de fallar, tanto para el jugador como para los enemigos.

## Sistema de puntuación

El jugador obtiene 100 puntos por cada enemigo derrotado.

Si consigue superar los tres combates, también recibe una bonificación equivalente a la vida que le quede al terminar la partida.

Al finalizar, su puntuación se compara con las del ranking, que almacena un máximo de diez resultados ordenados de mayor a menor puntuación.

En caso de empate, se mantiene primero el registro más antiguo.

## Ranking XML

Los resultados se almacenan en el archivo `datos/ranking.xml`, permitiendo conservar las puntuaciones entre distintas ejecuciones del programa.

Se ha utilizado Java DOM para leer y guardar los datos.

También se ha creado una DTD (`ranking.dtd`) para definir la estructura que debe seguir el XML y se han realizado pruebas de validación.

## XPath y XSLT

Se han realizado cinco consultas XPath para seleccionar nombres, filtrar jugadores por puntuación, buscar jugadores concretos, combinar condiciones y contar los registros del ranking.

Además, se ha utilizado XSLT para transformar el archivo XML en una página HTML que muestra la clasificación.

El diseño se aplica mediante un archivo CSS externo.

La transformación también contempla la situación en la que el ranking está vacío.

## Tecnologías utilizadas

- Java
- XML y DTD
- XPath
- XSLT
- HTML y CSS
- Git y GitHub
- Visual Studio Code

## Ejecución del proyecto

Para ejecutar el juego, es necesario tener instalado Java y abrir el proyecto desde Visual Studio Code o un entorno compatible.

La clase principal es `src/Main.java`.

El programa utiliza `datos/ranking.xml` para cargar y guardar las puntuaciones. Por tanto, debe ejecutarse desde la carpeta raíz del proyecto.

Para generar la página HTML del ranking, se puede transformar `datos/ranking.xml` utilizando `datos/ranking.xsl` mediante un procesador XSLT compatible.

## Control de versiones

El proyecto se ha desarrollado utilizando Git y GitHub, trabajando con diferentes ramas para separar las funcionalidades.

Se han utilizado ramas para desarrollar personajes, combates, ranking, XPath, XSLT y corregir errores.

Los cambios se han registrado mediante commits y posteriormente se han integrado utilizando merges.