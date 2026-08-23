# SpeedFast - Semana 2

Proyecto correspondiente a la actividad **"Definiendo una clase abstracta y su jerarquía"** de Desarrollo Orientado a Objetos II.

## Objetivo

Continuar el sistema de SpeedFast aplicando:

- Clase abstracta.
- Encapsulamiento.
- Herencia.
- Método implementado en la clase padre.
- Método abstracto.
- Sobrescritura.
- Polimorfismo.
- Reutilización de código.

## Estructura del proyecto

```text
SpeedFast_Semana2/
├── src/
│   ├── app/
│   │   └── Main.java
│   └── model/
│       ├── Pedido.java
│       ├── PedidoComida.java
│       ├── PedidoEncomienda.java
│       └── PedidoExpress.java
├── .gitignore
└── README.md
└── SALIDA_CONSOLA.txt
```

## Clase abstracta `Pedido`

La clase `Pedido` contiene los atributos comunes:

- `idPedido`
- `direccionEntrega`
- `distanciaKm`

También contiene:

```java
public void mostrarResumen()
public abstract int calcularTiempoEntrega()
```

`mostrarResumen()` tiene una implementación común para todos los pedidos, mientras que `calcularTiempoEntrega()` se implementa de manera diferente en cada subclase.

## Cálculo por tipo de pedido

### PedidoComida

`15 minutos + 2 minutos por kilómetro`

### PedidoEncomienda

`20 minutos + 1,5 minutos por kilómetro`

El resultado se redondea a un número entero de minutos.

### PedidoExpress

`10 minutos base + 5 minutos extra si la distancia supera los 5 km`

## Ejemplo usado en `Main`

| Tipo | Distancia | Tiempo |
|---|---:|---:|
| PedidoComida | 4 km | 23 min |
| PedidoEncomienda | 6 km | 29 min |
| PedidoExpress | 7 km | 15 min |

## Ejecución

Abrir el proyecto en IntelliJ IDEA y ejecutar `src/app/Main.java`.
