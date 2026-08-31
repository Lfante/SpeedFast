# Diagrama de clases - SpeedFast Semana 3

```mermaid
classDiagram
direction TB

class Despachable {
    <<interface>>
    +despachar() void
}
class Cancelable {
    <<interface>>
    +cancelar() void
}
class Rastreable {
    <<interface>>
    +verHistorial() void
}
class Pedido {
    <<abstract>>
    -int idPedido
    -String direccionEntrega
    -double distanciaKm
    -String repartidorAsignado
    +mostrarResumen() void
    +reservar() void
    +despachar() void
    +cancelar() void
    +verHistorial() void
    +calcularTiempoEntrega() int*
    +asignarRepartidor() void*
    +asignarRepartidor(String nombre) void*
}
class PedidoComida {
    -boolean requiereMochilaTermica
    +calcularTiempoEntrega() int
    +asignarRepartidor() void
    +asignarRepartidor(String nombre) void
}
class PedidoEncomienda {
    -double pesoKg
    -boolean embalajeAdecuado
    +calcularTiempoEntrega() int
    +asignarRepartidor() void
    +asignarRepartidor(String nombre) void
}
class PedidoExpress {
    -boolean disponibilidadInmediata
    +calcularTiempoEntrega() int
    +asignarRepartidor() void
    +asignarRepartidor(String nombre) void
}
Pedido ..|> Despachable
Pedido ..|> Cancelable
Pedido ..|> Rastreable
Pedido <|-- PedidoComida
Pedido <|-- PedidoEncomienda
Pedido <|-- PedidoExpress
```

`Pedido` implementa las tres interfaces y las subclases heredan esos contratos. Cada subclase personaliza el cálculo de tiempo y las dos formas de asignación de repartidor.
