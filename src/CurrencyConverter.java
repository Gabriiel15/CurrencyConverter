import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static final String API_KEY = "3af8e00901da290d5ac2cd53";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    private static Map<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        try {
            fetchExchangeRates();
            runConversionMenu();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }

    private static void fetchExchangeRates() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            parseJsonResponse(response.body());
        } else {
            throw new IOException("Error al obtener las tasas de cambio. Código de estado: " + response.statusCode());
        }
    }

    private static void parseJsonResponse(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        String[] currencyCodes = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};
        for (String code : currencyCodes) {
            if (rates.has(code)) {
                exchangeRates.put(code, rates.get(code).getAsDouble());
            }
        }
    }

    private static void runConversionMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nConvertidor de Monedas");
            System.out.println("1. ARS - Peso argentino");
            System.out.println("2. BOB - Boliviano boliviano");
            System.out.println("3. BRL - Real brasileño");
            System.out.println("4. CLP - Peso chileno");
            System.out.println("5. COP - Peso colombiano");
            System.out.println("6. USD - Dólar estadounidense");
            System.out.println("0. Salir");
            System.out.print("Seleccione la moneda de origen (0-6): ");

            int choice = scanner.nextInt();
            if (choice == 0) break;

            String fromCurrency = getCurrencyCode(choice);
            if (fromCurrency == null) continue;

            System.out.print("Ingrese la cantidad a convertir: ");
            double amount = scanner.nextDouble();

            System.out.print("Seleccione la moneda de destino (0-6): ");
            choice = scanner.nextInt();
            if (choice == 0) break;

            String toCurrency = getCurrencyCode(choice);
            if (toCurrency == null) continue;

            double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
        }
        scanner.close();
    }

    private static String getCurrencyCode(int choice) {
        switch (choice) {
            case 1: return "ARS";
            case 2: return "BOB";
            case 3: return "BRL";
            case 4: return "CLP";
            case 5: return "COP";
            case 6: return "USD";
            default:
                System.out.println("Opción inválida.");
                return null;
        }
    }

    private static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        return (amount / fromRate) * toRate;
    }
}