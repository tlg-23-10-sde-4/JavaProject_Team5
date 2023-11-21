package io.trivia;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class QuestionTest {
    @Before
    public void init() {
        List<String> tester = new ArrayList<String>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
    }

    @Test
    public void allChoicesRandom_shouldReturnAnswerChoicesInDifferentOrder_whenCalled() {
        List<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        System.out.println(question.allChoicesRandom());

    }

    @Test
    public void wrongChoices_shouldReturnListOfLenThree_whenCalled() {
        List<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        assertEquals(question.wrongChoices().size(), 3.0, .001);
    }
}