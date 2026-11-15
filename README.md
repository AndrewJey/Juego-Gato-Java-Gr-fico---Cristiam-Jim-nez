# Juego-Gato-Java-Gr-fico---Cristiam-Jim-nez

<!-- local-development:start -->
## Desarrollo local

Consulta [RUNNING.md](RUNNING.md) para ubicar cada componente, abrirlo en su IDE, compilarlo y conocer las comprobaciones realizadas y los requisitos pendientes.
<!-- local-development:end -->

<!-- build-repairs-20261115:start -->
## Reparación y comprobación — 2026-11-15

- Dependencias JPA/EclipseLink y Beans Binding fijadas e incluidas con sus POM y avisos. Se corrigió la capitalización del paquete gato.Logica y se retiraron referencias globales de NetBeans que producían un manifiesto JAR inválido.
- JDBC y las pantallas JPA usan una base H2 local compartida; se crean las tablas necesarias para jugadores y partidas. No requiere el servidor JIMENEZ de la máquina original.

Comprobado:

- Ant compila el JAR.
- SmokeGato verificó altas JDBC, consulta JPA y construcción de Nuevo Juego, Lista de Jugadores y Estadísticas con datos aislados.

Comandos:

```powershell
.\build-local.ps1 -Project 'gato/build.xml'
.\build-local.ps1 -Project 'gato/build.xml' -Target run
```

Alcance pendiente:

- Los datos locales nuevos se guardan en gato/data. No se migró automáticamente la antigua base SQL Server ni se comprobó cada secuencia posible de juego.

<!-- build-repairs-20261115:end -->
