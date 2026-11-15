

<!-- local-development:start -->
# Desarrollo local

Puedes abrir este repositorio en VS Code, Antigravity o Sublime Text. El compilador y los servicios necesarios dependen del componente indicado abajo.

## Java / NetBeans

En NetBeans 25, abre la carpeta que contiene `build.xml` como proyecto Ant. Selecciona un JDK igual o posterior al nivel de fuente del proyecto; las compilaciones de esta revisión usan JDK 24.0.2. El asistente busca NetBeans y el JDK y mantiene la configuración de usuario en `.local-build/`.

```powershell
.uild-local.ps1
.\build-local.ps1 -Project 'gato/build.xml' -Target run
```

Si hay varios proyectos, elige el deseado con `-Project`. Puedes indicar `-JavaHome` y `-NetBeansHome`. `-Target test` ejecuta las pruebas que declare el proyecto; un objetivo de pruebas vacío no acredita cobertura.

## Bases de datos

Revisa los scripts de esquema y crea una base de datos de prueba separada. SSMS 20 y pgAdmin 4 son clientes; SQL Server y PostgreSQL son motores distintos. Los scripts SQL Server no se ejecutan directamente en PostgreSQL. Las restauraciones deben hacerse sobre una base de prueba nueva. PostgreSQL 17 y 18 requieren comprobarse por separado.

## Componentes y validación

Inventario y compilaciones locales del 2026-11-15. Una compilación correcta no acredita todavía interacción, compatibilidad de base de datos, instalador ni despliegue.

| Componente | Tipo / destino | Validación |
| --- | --- | --- |
| [gato/build.xml](<gato/build.xml>) | netbeans-ant / 1.8 | Compila; comprobado el 2026-11-15; ver alcance actualizado abajo |

## Archivos ignorados

`.gitignore` excluye credenciales locales, estado del editor y salidas de las herramientas detectadas. No deja de versionar archivos que ya estaban en Git. Los manifiestos, archivos de bloqueo, recursos fuente y scripts de esquema forman parte del código.
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
