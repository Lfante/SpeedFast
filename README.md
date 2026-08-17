# SpeedFast - Semana 1

Proyecto correspondiente a la actividad **"Explorando la sobrecarga y sobreescritura en clases derivadas"** de Desarrollo Orientado a Objetos II.

## Objetivo

Representar distintos tipos de pedidos de la empresa SpeedFast y aplicar:

- Encapsulamiento.
- Herencia.
- Sobreescritura de métodos (`@Override`).
- Sobrecarga de métodos.
- Polimorfismo.

## Estructura del proyecto

```text
SpeedFast_Semana1/
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

## Clases

### Pedido

Clase base que contiene los atributos comunes:

- `idPedido`
- `direccionEntrega`
- `tipoPedido`

También contiene dos versiones de `asignarRepartidor()`:

```java
asignarRepartidor()
asignarRepartidor(String nombreRepartidor)
```

Esto permite demostrar la **sobrecarga** del método.

### PedidoComida

Sobrescribe el método para comprobar el requisito de mochila térmica.

### PedidoEncomienda

Sobrescribe el método para validar el peso y el embalaje de la encomienda.

### PedidoExpress

Sobrescribe el método para comprobar cercanía y disponibilidad inmediata del repartidor.


## Ejemplo de salida

```text
========================================
SPEEDFAST - PRUEBA DE POLIMORFISMO
========================================

[Pedido Comida]
ID pedido: 101
Dirección de entrega: Av. Providencia 1234, Santiago
Tipo de pedido: Comida
Asignando repartidor...
-> Verificando mochila térmica... OK

[Pedido Encomienda]
ID pedido: 102
Dirección de entrega: Av. Irarrázaval 2450, Ñuñoa
Tipo de pedido: Encomienda
Asignando repartidor...
-> Peso informado: 4.5 kg
-> Validando peso y embalaje... OK

[Pedido Express]
ID pedido: 103
Dirección de entrega: Gran Avenida 5200, San Miguel
Tipo de pedido: Compra Express
Asignando repartidor...
-> Repartidor más cercano encontrado a 1.2 km con disponibilidad inmediata.
```
