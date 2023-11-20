package io.trivia;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class QuestionTest {
    @Before
    public void init() {
        ArrayList<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
    }

    @Test
    public void allChoicesRandom_shouldReturnAnswerChoicesInDifferentOrder_whenCalled() {
        ArrayList<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        System.out.println(question.allChoicesRandom());

    }

    @Test
    public void wrongChoices_shouldReturnListOfLenThree_whenCalled() {
        ArrayList<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        assertEquals(question.wrongChoices().size(), 3.0, .001);
    }

    @Test
    public void nameAndQuestionDisplay_shouldReturnUpdatedHashset_whenCalled() {
        ArrayList<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        HashSet<String> hSet = new HashSet<>();
        //Question.nameAndQuestionDisplay();
    }
}