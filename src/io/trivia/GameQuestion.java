package io.trivia;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GameQuestion {

    public static void getJson() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/albums")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(GameQuestion::parse)
                .join();
    }

    // sample parse method for this particular ex. json layout
    public static String parse(String responseBody) {
        JSONArray arr = new JSONArray(responseBody);
        for (int i = 0; i < arr.length(); i++) {
            JSONObject album = arr.getJSONObject(i);
            int id = album.getInt("id");
            int userId = album.getInt("userId");
            String title = album.getString("title");
            System.out.println(id + " " + title + " " + userId);
        }
        return null;
    }
}