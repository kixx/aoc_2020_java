package aoc2020;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    List<String> sourceText;

    protected void readInput(String source) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(source);
        assert is != null;
        sourceText = new BufferedReader(new InputStreamReader(is,
                StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
    }

    protected List<Integer> convertToNumbers(List<String> source) {
        return source.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
