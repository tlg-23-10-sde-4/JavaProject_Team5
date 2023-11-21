package io.trivia;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class QuestionServiceTest {
    @Test
    public void getJsonShould_returnArrayList_whenCalled() {
        HashSet<String> b;
        List<String> a;
        a = QuestionService.newQuestion(Category.POLITICS);
        System.out.println(a);
    }
}