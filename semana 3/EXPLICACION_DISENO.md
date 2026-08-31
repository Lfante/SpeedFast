# Explicación del diseño

## Escalabilidad
La clase `Pedido` concentra los elementos compartidos. Si SpeedFast incorpora otro tipo de entrega, se puede crear una nueva subclase que herede de `Pedido` e implemente sus reglas particulares sin modificar las clases existentes.

## Reutilización
Los atributos `idPedido`, `direccionEntrega` y `distanciaKm`, junto con `mostrarResumen()`, `reservar()`, `despachar()`, `cancelar()` y `verHistorial()`, se implementan una sola vez y son reutilizados por las tres subclases.

## Polimorfismo
`Main` utiliza un arreglo de tipo `Pedido` que contiene objetos de las tres subclases. Java ejecuta la implementación correspondiente de `calcularTiempoEntrega()` según el tipo real del objeto. También existe sobrecarga con `asignarRepartidor()` y `asignarRepartidor(String nombre)`.

## Interfaces y desacoplamiento
`Despachable`, `Cancelable` y `Rastreable` separan operaciones funcionales. En `Main` se usan referencias de esos tipos para trabajar con contratos y no depender directamente de una subclase concreta.

## Mantenibilidad
Las reglas comunes están en `Pedido`, las reglas particulares en las subclases, los contratos en interfaces y la simulación en `Main`. Esto disminuye código repetido y facilita modificar una regla sin afectar innecesariamente otras clases.
