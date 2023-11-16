package io.trivia;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameQuestionTest {
    @Test
    public void getJsonShould_returnArrayList_whenCalled() {
        ArrayList<String> a = new ArrayList<>();
        a = QuestionService.parse(QuestionService.getJson(Category.ANIMALS));
    }
}