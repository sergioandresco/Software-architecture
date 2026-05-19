## Descripción
Implementación del patrón de diseño creacional **Builder** asistido por un **Director** para el sistema de configuración de automóviles.

## Decisiones Arquitectónicas (ADR)
- **Inmutabilidad:** Se aplicó el modificador `final` a todos los atributos de la clase `Automovil` y se eliminaron los métodos *setters*. El objeto solo se puede instanciar atómicamente a través del método `obtenerResultado()` del Builder.
- **Desacoplamiento:** Se implementó una interfaz `AutomovilBuilder` y una clase `DirectorAutomotriz` para encapsular las recetas de construcción (ej. Paquete Premium y Deportivo), separando la lógica de negocio de la representación del producto final.
- **Prevención de Anti-patrones:** Se evitó el uso del "Telescoping Constructor" permitiendo una configuración paso a paso segura e intuitiva.
