package gabrielfigueiredo;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    Gson gson = new Gson();
    String baseURL = "https://v6.exchangerate-api.com/v6/";
    String keyAPI = "";

    public double convertePar(Moeda primeiraMoeda, Moeda segundaMoeda) throws IOException, InterruptedException {
        String url = baseURL + keyAPI + "/pair/" + primeiraMoeda.getCodigo() + "/" + segundaMoeda.getCodigo();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Conversao conversao = gson.fromJson(response.body(), Conversao.class);
        return conversao.conversion_rate();
    }


}
