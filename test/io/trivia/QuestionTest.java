package io.trivia;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class QuestionTest {

    @Test
    public void wrongChoices_shouldReturnListOfLenThree_whenCalled() {
        List<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        assertEquals(question.wrongChoices().size(), 3);
    }

    @Test
    public void allChoicesRandom_shouldReturnListLenFour_whenCalled() {
        List<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        assertEquals(question.allChoicesRandom().size(), 4);
    }

    @Test
    public void getBody_shouldReturnCorrectBody() {
        List<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        assertEquals(question.getBody(), "body");
    }

    @Test
    public void getAnswer_shouldReturnCorrectAnswer() {
        List<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        assertEquals(question.getAnswer(), "ANSWER");
    }

    @Test
    public void getWrongChoices_shouldReturnCorrectWrongChoices () {
        List<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        assertEquals("WRONGCHOICE1", question.getWrongChoice1());
        assertEquals("WRONGCHOICE2", question.getWrongChoice2());
        assertEquals("WRONGCHOICE3", question.getWrongChoice3());
    }

    @Test
    public void allChoicesRandom_shouldIncludeAllChoices() {
        List<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        List<String> choices = question.allChoicesRandom();
        assertTrue(question.allChoicesRandom().contains("ANSWER"));
        assertTrue(question.allChoicesRandom().contains("WRONGCHOICE1"));
        assertTrue(question.allChoicesRandom().contains("WRONGCHOICE2"));
        assertTrue(question.allChoicesRandom().contains("WRONGCHOICE3"));
        assertEquals(4, choices.size());
    }

    @Test
    public void wrongChoices_shouldReturnThreeWrongChoices() {
        List<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        List<String> wrongChoices = question.wrongChoices();
        assertTrue(wrongChoices.contains("WRONGCHOICE1"));
        assertTrue(wrongChoices.contains("WRONGCHOICE2"));
        assertTrue(wrongChoices.contains("WRONGCHOICE3"));
        assertEquals(3, wrongChoices.size());
    }

    @Test
    public void toString_shouldReturnFormattedString() {
        List<String> tester = new ArrayList<>(Arrays.asList("body", "answer", "wrongchoice1", "wrongchoice2", "wrongchoice3"));
        Question question = new Question(tester);
        assertEquals("Question{body='body', answer='ANSWER', wrongChoice1='WRONGCHOICE1', wrongChoice2='WRONGCHOICE2', wrongChoice3='WRONGCHOICE3'}", question.toString());
    }
}