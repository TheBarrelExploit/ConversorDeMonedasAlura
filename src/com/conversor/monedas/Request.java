package com.conversor.monedas;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;


public class Request  {
    private String apiKey = System.getenv().get("KEYVALUE");

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();

    public void getConvertMoney(String baseCode, String targetCode, Double value) {
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + baseCode + "/" + targetCode + "/" + value;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            ConversorMoneda conversor = gson.fromJson(response.body(), ConversorMoneda.class);
            Moneda moneda = new Moneda(conversor);

            if (moneda.getResult().equals("error") ) {
                String [] datos = response.body().split(",");
                System.out.println("Error en la consulta, código retornado api rest: " + datos[datos.length -1].split(":")[1].replaceAll("[\\\\}]", "").trim());
                return;
            }
            System.out.println("Cada " + moneda.getBaseCode() + " corresponden a " + moneda.getConversionRate() + " "+ moneda.getTargetCode());
            System.out.println( value + " " + moneda.getBaseCode() + " corresponden a " + moneda.getConversion() + " "+ moneda.getTargetCode());
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
