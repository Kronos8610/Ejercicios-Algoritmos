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

## Estructura del proyecto

```
Entrevista/
├── src/
│   ├── ComsumoDeEnergia.py
│   └── ProblemaMochila.java
├── .vscode/
│   └── settings.json
└── consumo_energia.json   (generado al ejecutar el script Python)
```
