# SpeedFast - Semana 5

Actividad de **Desarrollo Orientado a Objetos II**: **Sincronizando procesos en sistemas concurrentes**.

## Objetivo
Simular una zona de carga compartida por varios repartidores y utilizar sincronización para evitar que dos hilos retiren el mismo pedido.

## Implementado
- Clase `Pedido`.
- Enum `EstadoPedido` con `PENDIENTE`, `EN_REPARTO` y `ENTREGADO`.
- Clase compartida `ZonaDeCarga`.
- Métodos `synchronized` para agregar y retirar pedidos.
- Clase `Repartidor implements Runnable`.
- Tres repartidores ejecutándose simultáneamente.
- `Thread.sleep()` para simular el tiempo de entrega.
- `ExecutorService` con tres hilos.
- Manejo de `InterruptedException`.
- Verificación final de que la zona de carga quede vacía.

## Estructura
```text
semana 5/
├── src/
│   ├── app/
│   │   └── Main.java
│   └── model/
│       ├── EstadoPedido.java
│       ├── Pedido.java
│       ├── Repartidor.java
│       └── ZonaDeCarga.java
├── .gitignore
├── README.md
└── SALIDA_CONSOLA.txt
```

## Sincronización
`ZonaDeCarga` es el recurso compartido. Sus métodos `agregarPedido()` y `retirarPedido()` son `synchronized`, por lo que un solo hilo puede modificar la lista a la vez.

Cuando se retira un pedido, dentro de la misma sección sincronizada cambia de `PENDIENTE` a `EN_REPARTO` y se elimina de la zona de carga. Esto evita que dos repartidores reciban el mismo pedido. Después, el repartidor simula la entrega y lo cambia a `ENTREGADO`.

## Importante sobre la salida
El orden de Juan, Camila y Pedro puede cambiar entre ejecuciones porque trabajan concurrentemente. Lo importante es que cada pedido se retire y entregue una sola vez y que al final aparezca `Todos los pedidos han sido entregados correctamente`.
