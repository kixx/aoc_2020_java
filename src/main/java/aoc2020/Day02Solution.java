package aoc2020;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02Solution extends Solution {

    String POLICY_REGEX = "^(\\d+)-(\\d+) ([a-z]): ([a-z]+)$";

    public Day02Solution(String source) {
        readInput(source);
    }


    public int countValid(Function<Policy, Boolean> policyMatcher) {
        Pattern policyPattern = Pattern.compile(POLICY_REGEX);
        int matches = 0;
        for(String line: sourceText) {
            Matcher matcher = policyPattern.matcher(line);
            if(matcher.matches()) {
                int min = Integer.parseInt(matcher.group(1));
                int max = Integer.parseInt(matcher.group(2));
                char letter = matcher.group(3).charAt(0);
                String password = matcher.group(4);
                Policy policy = new Policy(min, max, letter, password);
                if (policyMatcher.apply(policy))  {
                    matches++;
                }
            }
        }
        return matches;
    }

    public int solution() {
        return countValid(LetterCounter::count);
    }

    public int extra() {
        return countValid(LetterPositionChecker::check);
    }

    static class LetterCounter {
        static public boolean count(Policy policy) {
            long count = policy.password.chars().filter(ch -> ch == policy.letter).count();
            return policy.min <= count && count <= policy.max;
        }
    }

    static class LetterPositionChecker {
        static public boolean check(Policy policy) {
            char first = policy.password.charAt(policy.min-1);
            char last = policy.password.charAt(policy.max-1);
            return (policy.letter == first || policy.letter == last) && first != last;
        }
    }

    static class Policy {
        int min;
        int max;
        char letter;
        String password;

        public Policy(int min, int max, char letter, String password) {
            this.min = min;
            this.max = max;
            this.letter = letter;
            this.password = password;
        }
    }

    public static void main(String[] args) {
        var day02 = new Day02Solution("day02.txt");
        System.out.println(day02.solution());
        System.out.println(day02.extra());
    }
}
