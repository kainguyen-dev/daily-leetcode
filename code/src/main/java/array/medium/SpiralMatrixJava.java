package array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixJava {

    private static final Dir[] dirOrder = {Dir.RIGHT, Dir.DOWN, Dir.LEFT, Dir.TOP};
    private static int dirCount = 0;

    enum Dir {
        RIGHT, LEFT, TOP, DOWN,
    }

    private static Pair<Integer, Integer> nextStep(Pair<Integer, Integer> cur,
                                                   Dir curDir,
                                                   boolean[][] visited,
                                                   int nRow,
                                                   int nCol) {

        Pair<Integer, Integer> newCoordinate;
        switch (curDir) {
            case RIGHT -> newCoordinate = new Pair<>(cur.first, cur.second + 1);
            case LEFT -> newCoordinate = new Pair<>(cur.first, cur.second - 1);
            case TOP -> newCoordinate = new Pair<>(cur.first - 1, cur.second);
            case DOWN -> newCoordinate = new Pair<>(cur.first + 1, cur.second);
            default -> throw new IllegalStateException("Unexpected value: " + curDir);
        }

        // Check if change direction is needed (four corners)
        if ((newCoordinate.first == 0 && newCoordinate.second == nCol - 1)
                || (newCoordinate.first == nRow - 1 && newCoordinate.second == nCol - 1)
                || (newCoordinate.first == nRow - 1 && newCoordinate.second == 0)
                || visited[newCoordinate.first][newCoordinate.second]) {
            dirCount = (dirCount + 1) % 4;
            curDir = dirOrder[dirCount];
            switch (curDir) {
                case RIGHT -> newCoordinate = new Pair<>(cur.first, cur.second + 1);
                case LEFT -> newCoordinate = new Pair<>(cur.first, cur.second - 1);
                case TOP -> newCoordinate = new Pair<>(cur.first - 1, cur.second);
                case DOWN -> newCoordinate = new Pair<>(cur.first + 1, cur.second);
            }
        }

        return newCoordinate;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        int total = nRow * nCol;
        int count = 0;
        Dir curDir;

        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[nRow][nCol];
        Pair<Integer, Integer> curCoordinate = new Pair<>(0, 0);

        while (count < total) {
            System.out.println("Print cor: " + curCoordinate);
            curDir = dirOrder[dirCount];
            result.add(matrix[curCoordinate.first][curCoordinate.second]);
            visited[curCoordinate.first][curCoordinate.second] = true;
            curCoordinate = nextStep(curCoordinate, curDir, visited, nRow, nCol);
            count++;
        }

        return result;
    }

    static class Pair<F, S> {
        public final F first;
        public final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

}
