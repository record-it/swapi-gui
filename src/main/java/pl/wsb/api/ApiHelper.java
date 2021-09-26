package pl.wsb.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class ApiHelper {
    private static final HttpClient client = HttpClient.newHttpClient();

    static public void getObjectFromApi(String url, int id, Consumer<String> consumer) throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .whenCompleteAsync((response, exeption) -> {
                    if (exeption != null){
                        System.err.println("Problem z odpowiedzią z serwera!");
                    }
                    consumer.accept(response.body());
                });
    }

    static public String getBodyFromApi(String url) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
