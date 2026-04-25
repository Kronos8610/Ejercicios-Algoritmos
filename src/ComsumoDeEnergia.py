import requests
import json

def obtener_temperaturas_open_meteo(latitud, longitud):
    url = f"https://api.open-meteo.com/v1/forecast?latitude={latitud}&longitude={longitud}&hourly=temperature_2m"

    respuesta = requests.get(url)

    datos = respuesta.json()

    if respuesta.status_code == 200:
        temperaturas_horarias = datos["hourly"]["temperature_2m"]

        temperaturas_diarias = [temperaturas_horarias[i:i + 24] for i in range(0, len(temperaturas_horarias), 24)]

        dias = ["lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"]

        temperaturas = dict(zip(dias, temperaturas_diarias))

        return temperaturas
    else:
        return None

def calcular_consumo(temperaturas):
    dias = list(temperaturas.keys())
    resultados = []

    for dia in dias:
        temperaturas_horarias = temperaturas[dia]

        TMD = sum(temperaturas_horarias) / len(temperaturas_horarias)

        consumo_energia = max(0, (15 - TMD))

        resultado = {
            "dia": dia,
            "TMD": TMD,
            "temperaturas_horarias": temperaturas_horarias,
            "consumo_energia": consumo_energia
        }

        resultados.append(resultado)

    return resultados

def guardar_resultados(resultados):
    with open('consumo_energia.json', 'w') as archivo:
        json.dump(resultados, archivo, indent=4)

latitud = 40.4168
longitud = -3.7038

temperaturas = obtener_temperaturas_open_meteo(latitud, longitud)

if temperaturas is not None:
    resultados = calcular_consumo(temperaturas)

    guardar_resultados(resultados)

    for resultado in resultados:
        print(f"Día: {resultado['dia']}")
        print(f"TMD: {resultado['TMD']}")
        print(f"Temperaturas horarias: {resultado['temperaturas_horarias']}")
        print(f"Consumo de energía: {resultado['consumo_energia']}\n")
else:
    print("No se pudieron obtener las temperaturas.")
