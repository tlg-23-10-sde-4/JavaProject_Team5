package io.trivia.app;

import io.trivia.Category;
import io.trivia.QuestionService;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameHostTest {
    @Test
    public void welcomePromptTest() {

        GameHost a = new GameHost();
        //a.namePrompt();

        ArrayList<String> a = new ArrayList<>();
        a = QuestionService.newQuestion(Category.ANIMALS);
        System.out.println(a);

    }
}