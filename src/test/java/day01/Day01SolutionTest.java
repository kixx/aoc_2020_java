package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01SolutionTest {

    Day01Solution day01;

    @BeforeEach
    public void init() {
        day01 = new Day01Solution("day01/test.txt");
    }

    @Test
    public void testDay01Solution() {
        assertEquals(day01.solution(2020), 514579);
    }

    @Test
    public void testDay01Extra() {
        assertEquals(day01.extra(2020), 241861950);
    }
}
