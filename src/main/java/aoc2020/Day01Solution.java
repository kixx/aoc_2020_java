package aoc2020;

public class Day01Solution extends Solution {

    public Day01Solution(String source) {
        readInput(source);
    }

    public static void main(String[] args) {
        var day01 = new Day01Solution("day01.txt");
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


}
