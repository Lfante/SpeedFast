# SpeedFast - Semana 4

Actividad de **Desarrollo Orientado a Objetos II**:  
**Ejecutando tareas en paralelo con hilos en Java**.

## Implementado

- Clase abstracta `Pedido`.
- `PedidoComida`, `PedidoEncomienda` y `PedidoExpress`.
- Interfaces `Despachable`, `Cancelable` y `Rastreable`.
- Clase `Repartidor` con nombre y lista de pedidos.
- `Repartidor implements Runnable`.
- `Thread.sleep()` con pausas aleatorias.
- Tres repartidores con dos pedidos cada uno.
- `ExecutorService` con tres hilos.
- `shutdown()` y `awaitTermination()`.
- Manejo de `InterruptedException`.
- Manejo de errores inesperados por pedido.
- Historial compartido con `CopyOnWriteArrayList` para evitar problemas de concurrencia.

## Estructura

```text
semana 4/
├── src/
│   ├── app/
│   │   └── Main.java
│   ├── interfaces/
│   │   ├── Cancelable.java
│   │   ├── Despachable.java
│   │   └── Rastreable.java
│   └── model/
│       ├── Pedido.java
│       ├── PedidoComida.java
│       ├── PedidoEncomienda.java
│       ├── PedidoExpress.java
│       └── Repartidor.java
├── .gitignore
├── README.md
└── SALIDA_CONSOLA.txt
```

## Cómo funciona

Cada `Repartidor` procesa su propia lista secuencialmente dentro de `run()`.  
Los tres objetos `Repartidor` se ejecutan simultáneamente mediante un `ExecutorService`.

Cada entrega realiza una pausa aleatoria con `Thread.sleep()`. Por eso el orden exacto
de los mensajes puede cambiar entre ejecuciones; ese comportamiento es esperado en una
simulación concurrente.

## Ejecución en IntelliJ

1. Abrir la carpeta `semana 4`.
2. Marcar `src` como **Sources Root** si es necesario.
3. Abrir `src/app/Main.java`.
4. Ejecutar `Main.main()`.
