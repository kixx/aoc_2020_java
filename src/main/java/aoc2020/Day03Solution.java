package aoc2020;

public class Day03Solution extends Solution {
    public Day03Solution(String source) {
        readInput(source);
    }

    public long solution() {
        return getTrees(1,3);
    }



    private long getTrees(int dx, int dy) {
        int sum = 0, j = 0;
        for(int i=0; i < sourceText.size(); i+=dx) {
            j %= sourceText.get(i).length();
            //System.out.println(String.format("Checking %d,%d",i,j));
            if (sourceText.get(i).charAt(j) == '#') {
                //System.out.println("Tree found");
                sum++;
            }
            j += dy;
        }
        return sum;
    }

    public long extra() {
        final long firstTree = getTrees(1, 1);
        final long thirdTree = getTrees(1, 3);
        final long fifthTree = getTrees(1, 5);
        final long seventhTree = getTrees(1, 7);
        final long lastOne = getTrees(2, 1);
        return firstTree * thirdTree * fifthTree * seventhTree * lastOne;
    }

    public static void main(String[] args) {
        var day03 = new Day03Solution("day03.txt");
        System.out.println(day03.solution());
        System.out.println(day03.extra());
    }
}
