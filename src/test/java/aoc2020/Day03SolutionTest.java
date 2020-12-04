package aoc2020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day03SolutionTest {

    Day03Solution day03;

    @BeforeEach
    public void init() {
        day03 = new Day03Solution("day03.txt");
    }

    @Test
    public void testDay02Solution() {
        assertEquals(day03.solution(), 7);
    }

    @Test
    public void testDay02Extra() {
        assertEquals(day03.extra(), 336);
    }
}
