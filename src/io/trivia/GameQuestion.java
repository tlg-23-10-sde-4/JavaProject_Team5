package io.trivia;

import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class GameQuestion {

    public static void getJson() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://beta-trivia.bongobot.io/?search=&category=&type=boolean&difficulty=easy&limit=1")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(GameQuestion::parse)
                .join();
    }

    // sample parse method for this particular ex. json layout
    public static ArrayList<String> parse(String responseBody) {
        ArrayList<String> res = new ArrayList<>();
        JSONArray arr = new JSONArray(responseBody);
        for (int i = 0; i < arr.length(); i++) {
            JSONObject result = arr.getJSONObject(i);
            String question = result.getString("question");
            String correctAnswer = result.getString("correct_answer");
            String pureQuestion = StringEscapeUtils.unescapeHtml3(question);
            res.add(pureQuestion);
            res.add(correctAnswer);
            System.out.println(res); // this line for testing purposes
        }
        return res;
    }
}