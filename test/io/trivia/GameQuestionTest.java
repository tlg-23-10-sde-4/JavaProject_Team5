package io.trivia;

import org.junit.Test;

import java.util.ArrayList;

public class GameQuestionTest {
    @Test
    public void getJsonShould_returnArrayList_whenCalled() {
        ArrayList<String> a;
        a = QuestionService.newQuestion(Category.ANIMALS);
        System.out.println(a);
    }
}