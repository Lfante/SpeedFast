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

## Ejecución

1. Abrir la carpeta del proyecto en IntelliJ IDEA.
2. Configurar JDK 17 o superior si IntelliJ lo solicita.
3. Ejecutar `src/app/Main.java`.
4. Revisar la salida de consola para comprobar los distintos comportamientos.

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

## Entrega

El proyecto está preparado para:

- abrirse y ejecutarse en IntelliJ IDEA;
- subirse a un repositorio público de GitHub;
- comprimirse y entregarse en formato `.zip`.
