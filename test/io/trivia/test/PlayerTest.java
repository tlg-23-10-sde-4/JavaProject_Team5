package io.trivia.test;

import io.trivia.Player;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class PlayerTest {
    private Player player;
    
    @Before
    public void setUp() throws Exception {
        player = new Player("TestPlayer", 0);
    }

    @Test
    public void testGetName() {
        assertEquals("TestPlayer", player.getName());
    }

    @Test
    public void testGetScore() {
        assertEquals(0, player.getScore());
    }

    @Test
    public void testToString() {
    }
}