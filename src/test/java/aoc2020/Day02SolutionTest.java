package aoc2020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02SolutionTest {

    Day02Solution day02;

    @BeforeEach
    public void init() {
        day02 = new Day02Solution("day02.txt");
    }

    @Test
    public void testDay02Solution() {
        assertEquals(day02.solution(), 2);
    }

    @Test
    public void testDay02Extra() {
        assertEquals(day02.extra(), 1);
    }
}
