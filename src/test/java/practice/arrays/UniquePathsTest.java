package test.java.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import main.java.practice.arrays.UniquePaths;
import org.junit.jupiter.api.Test;

class UniquePathsTest {

  UniquePaths uniquePaths = new UniquePaths();

  @Test
  void countUniquePaths() {

    int m = 3;
    int n = 2;
    int[][] grid = new int[m][n];

    for (int i = 0; i < m; i++) {
      Arrays.fill(grid[i], 0);
    }
    assertEquals(3, uniquePaths.countUniquePaths(grid));

  }

  @Test
  void countUniquePaths12() {

    int m = 3;
    int n = 7;
    int[][] grid = new int[m][n];

    for (int i = 0; i < m; i++) {
      Arrays.fill(grid[i], 0);
    }
    assertEquals(28, uniquePaths.countUniquePaths(grid));

  }

  @Test
  void countUniquePathsWithObstacles() {
    int m = 3;
    int n = 3;
    int[][] grid = new int[m][n];

    for (int i = 0; i < m; i++) {
      Arrays.fill(grid[i], 0);
    }
    grid[1][1] = 1;
    assertEquals(2, uniquePaths.countUniquePathsWithObstacles(grid));
  }

  @Test
  void countUniquePathsWithObstaclesWithStartAndStop() {

    int m = 3;
    int n = 4;
    int[][] grid = new int[m][n];

    grid[0] = new int[]{1, 0, 0, 0};
    grid[1] = new int[]{0, 0, 0, 0};
    grid[2] = new int[]{0, 0, 2, -1};
    assertEquals(6, uniquePaths.countUniquePathsWithObstaclesWithStartAndStop(grid));

  }
}