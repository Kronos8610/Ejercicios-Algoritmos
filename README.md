# Entrevista - Ejercicios

Este proyecto contiene dos ejercicios independientes: uno en Python y otro en Java.

---

## Ejercicio 1: Consumo de Energía (`src/ComsumoDeEnergia.py`)

Obtiene las temperaturas horarias de Madrid para los próximos 7 días usando la API pública de [Open Meteo](https://open-meteo.com/). Para cada día calcula la **Temperatura Media Diaria (TMD)** y el **consumo de energía** estimado como `max(0, 15 - TMD)`. Los resultados se imprimen por consola y se guardan en `consumo_energia.json`.

### Requisitos

- Python 3.x
- Librería `requests`:

```bash
pip install requests
```

### Ejecución

```bash
python src/ComsumoDeEnergia.py
```

---

## Ejercicio 2: Problema de la Mochila (`src/ProblemaMochila.java`)

Resuelve el clásico **problema de la mochila 0/1** usando programación dinámica. Dados 4 dispositivos (Laptop, Tablet, Smartphone y Cámara) con sus pesos y beneficios, encuentra la combinación de dispositivos que maximiza el beneficio sin superar la capacidad máxima de la mochila (6 kg).

### Requisitos

- Java JDK 8 o superior

### Ejecución

Desde VS Code basta con pulsar **Run** sobre el archivo. Desde terminal:

```bash
javac src/ProblemaMochila.java -d bin
java -cp bin ProblemaMochila
```

---

## Ejercicio 3: Juguetería Concurrente (`src/Ejercicio_jugueteria/`)

Simula una juguetería navideña usando **concurrencia en Java** con semáforos. Tres elfos fabrican juguetes y los depositan en una encimera (capacidad máxima 7). Los niños buenos cogen juguetes para jugar y los devuelven, mientras que los niños malos los rompen sin devolverlos. La simulación termina cuando todos los elfos han fabricado sus juguetes.

| Actor | Hilos | Comportamiento |
|---|---|---|
| Elfo | 3 | Fabrica 10-20 juguetes y los pone en la encimera |
| Niño Bueno | 5 | Coge un juguete, juega 2-5 s, lo devuelve |
| Niño Malo | 20 | Coge un juguete, lo rompe; expulsado tras 3 roturas |

### Requisitos

- Java JDK 16 o superior 

### Ejecución

```bash
cd src/Ejercicio_jugueteria
javac *.java
java Jugueteria
```

---

## Estructura del proyecto

```
├── src/
│   ├── ComsumoDeEnergia.py
│   ├── ProblemaMochila.java
│   └── Ejercicio_jugueteria/
│       ├── Jugueteria.java   (main)
│       ├── Encimera.java
│       ├── Juguete.java
│       ├── Elfo.java
│       ├── Nino_Bueno.java
│       └── Nino_Malo.java
├── .vscode/
│   └── settings.json
└── consumo_energia.json   (generado al ejecutar el script Python)
```
