package io.trivia;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;
import java.util.List;
import static org.junit.Assert.*;

public class QuestionServiceTest {
    @Test
    public void newQuestionShould_returnNonEmptyArrayList_whenCalled() {
        HashSet<String> b;
        List<String> a;
        a = QuestionService.newQuestion(Category.POLITICS);
        assertTrue(a != null);
    }

    @Test
    public void newQuestion_shouldReturnArrayOfLengthFive_whenCalled() {
        List<String> a = QuestionService.newQuestion(Category.ANIMALS);
        assertEquals(5, a.size());
    }
}