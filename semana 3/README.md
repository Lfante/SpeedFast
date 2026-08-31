# SpeedFast - Semana 3

Actividad sumativa de **Desarrollo Orientado a Objetos II**: **Diseñando un sistema orientado a objetos con clases abstractas, polimorfismo e interfaces**.

## Implementado
- Clase abstracta `Pedido`.
- `PedidoComida`, `PedidoEncomienda` y `PedidoExpress`.
- Sobrescritura y sobrecarga de `asignarRepartidor`.
- Método abstracto `calcularTiempoEntrega()`.
- Interfaces `Despachable`, `Cancelable` y `Rastreable`.
- Reserva, asignación automática/manual, cálculo de tiempo, despacho, cancelación e historial.
- Historial con `ArrayList`.
- Diagrama de clases y explicación del diseño.

## Estructura
```text
semana 3/
├── src/
│   ├── app/Main.java
│   ├── interfaces/
│   │   ├── Cancelable.java
│   │   ├── Despachable.java
│   │   └── Rastreable.java
│   └── model/
│       ├── Pedido.java
│       ├── PedidoComida.java
│       ├── PedidoEncomienda.java
│       └── PedidoExpress.java
├── DIAGRAMA_CLASES.md
├── EXPLICACION_DISENO.md
├── SALIDA_CONSOLA.txt
├── README.md
└── .gitignore
```

## Ejecución en IntelliJ
1. Abrir la carpeta `semana 3`.
2. Marcar `src` como **Sources Root** si IntelliJ no lo hace automáticamente.
3. Abrir `src/app/Main.java`.
4. Ejecutar `Main.main()`.
