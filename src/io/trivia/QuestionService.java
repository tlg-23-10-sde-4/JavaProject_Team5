package io.trivia;

import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class QuestionService {

    public static String getJson(Category category) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://beta-trivia.bongobot.io/?search=&category="
                        + category + "&type=multiple&difficulty=easy&limit=1")).build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
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
            JSONArray wrongAnswer = result.getJSONArray("incorrect_answers");
            String pureQuestion = StringEscapeUtils.unescapeHtml4(question);
            pureQuestion = StringEscapeUtils.unescapeHtml3(question);
            int intId = result.getInt("id");
            String id = String.valueOf(intId);

            res.add(pureQuestion);
            res.add(correctAnswer);
            for (Object s : wrongAnswer){
                res.add(s.toString());
            }
            res.add(id);
            //System.out.println(res); // this line for testing purposes
        }
        return res;
    }

    public static ArrayList<String> newQuestion(Category category) {
        return QuestionService.parse(QuestionService.getJson(category));
    }
}