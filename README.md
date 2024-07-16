# Convertidor de Monedas

Este es un programa de conversión de monedas implementado en Java. Utiliza la API de ExchangeRate-API para obtener las tasas de cambio actualizadas.

## Características

- Convierte entre las siguientes monedas:
  - ARS - Peso argentino
  - BOB - Boliviano boliviano
  - BRL - Real brasileño
  - CLP - Peso chileno
  - COP - Peso colombiano
  - USD - Dólar estadounidense
- Interfaz de usuario por consola
- Actualización automática de tasas de cambio

## Requisitos

- Java 11 o superior
- IntelliJ IDEA (recomendado)
- Conexión a internet para obtener las tasas de cambio
- Cuenta en ExchangeRate-API para obtener una clave API

## Configuración

1. Clona este repositorio
2. Abre el proyecto en IntelliJ IDEA
3. Asegúrate de tener las dependencias de Gson instaladas
4. Obtén una clave API gratuita en [ExchangeRate-API](https://www.exchangerate-api.com/)
5. Reemplaza "TU_CLAVE_API_AQUI" en la clase `CurrencyConverter` con tu clave API de ExchangeRate-API

## Uso

1. Ejecuta la clase `CurrencyConverter`
2. Sigue las instrucciones en la consola para realizar conversiones de moneda:
   - Selecciona la moneda de origen
   - Ingresa la cantidad a convertir
   - Selecciona la moneda de destino
3. El programa mostrará el resultado de la conversión
4. Puedes realizar múltiples conversiones en una sola ejecución del programa

## Notas

- Las tasas de cambio se obtienen al inicio del programa
- Para obtener tasas actualizadas, reinicia el programa
- El programa utiliza USD como moneda base para las conversiones

## Solución de problemas

Si encuentras errores relacionados con la API, verifica:
- Tu conexión a internet
- La validez de tu clave API
- El estado del servicio en [ExchangeRate-API Status](https://www.exchangerate-api.com/status)

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue para discutir cambios mayores antes de hacer un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## Descargo de responsabilidad

Este programa es solo para fines educativos. Las tasas de cambio pueden no ser adecuadas para transacciones financieras reales. Utiliza servicios financieros profesionales para operaciones monetarias reales.
