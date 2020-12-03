package day01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Day01Solution {

    List<String> sourceText;

    public Day01Solution(String source) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(source);
        assert is != null;
        sourceText = new BufferedReader(new InputStreamReader(is,
                StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        var day01 = new Day01Solution("day01/input.txt");
        System.out.println(day01.solution(2020));
        System.out.println(day01.extra(2020));
    }

    public long solution(long target) {
        var numbers = convertToNumbers(sourceText);
        long solution = 0;
        for(int i = 0; i < numbers.size(); i++) {
            for(int j = i; j < numbers.size(); j++) {
                if(numbers.get(i) + numbers.get(j)== target) {
                    solution = (long) numbers.get(i) * numbers.get(j);
                }
            }
        }
        return solution;
    }

    public long extra(long target) {
        var numbers = convertToNumbers(sourceText);
        long solution = 0;
        for(int i = 0; i < numbers.size(); i++) {
            for(int j = i; j < numbers.size(); j++) {
                for(int k = j; k < numbers.size(); k++)
                if(numbers.get(i) + numbers.get(j) + numbers.get(k) == target) {
                    solution = (long) numbers.get(i) * numbers.get(j) * numbers.get(k);
                }
            }
        }
        return solution;
    }


    private List<Integer> convertToNumbers(List<String> source) {
        return source.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
