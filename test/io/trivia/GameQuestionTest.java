package io.trivia;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class GameQuestionTest {
    @Test
    public void getJsonShould_returnArrayList_whenCalled() {
        HashSet<String> b;
        ArrayList<String> a;
        a = QuestionService.newQuestion(Category.ANIMALS);
        System.out.println(a);
        System.out.println();
    }
}