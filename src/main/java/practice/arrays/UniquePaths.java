package main.java.practice.arrays;

public class UniquePaths {

  public int countUniquePaths(int[][] grid) {

    int m = grid.length;
    int n = grid[0].length;
    int[][] paths = new int[m][n];
    paths[0][0] = 1;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        paths[i][j] = ((i > 0) ? paths[i - 1][j] : 0) + ((j > 0) ? paths[i][j - 1] : 0);
      }
    }

    return paths[m - 1][n - 1];
  }

  public int countUniquePathsWithObstacles(int[][] grid) {

    int m = grid.length;
    int n = grid[0].length;
    int[][] paths = new int[m][n];
    paths[0][0] = 1;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (i == 0 && j == 0) {
          if (grid[0][0] == 1) {
            paths[0][0] = 0;
          }
          continue;
        }

        if (grid[i][j] == 1) {
          paths[i][j] = 0;
        } else {
          paths[i][j] = ((i > 0) ? paths[i - 1][j] : 0) + ((j > 0) ? paths[i][j - 1] : 0);
        }
      }
    }

    return paths[m - 1][n - 1];
  }

  public int countUniquePathsWithObstaclesWithStartAndStop(int[][] grid) {

    int m = grid.length;
    int n = grid[0].length;
    int[][] paths = new int[m][n];
    boolean stop = false;
    int src = -1;
    int des = -1;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (i == 0 && j == 0) {
          if (grid[0][0] == -1) {
            paths[0][0] = 0;
          }
          if (grid[0][0] == 1) {
            paths[0][0] = 1;
          }
          continue;
        }

        if (grid[i][j] == 1) {
          paths[i][j] = 1;
        } else if (grid[i][j] == -1) {
          paths[i][j] = 0;
        } else {
          paths[i][j] = ((i > 0) ? paths[i - 1][j] : 0) + ((j > 0) ? paths[i][j - 1] : 0);
        }

        if (grid[i][j] == 2) {
          stop = true;
          src = i;
          des = j;
          break;
        }
      }
      if (stop) {
        break;
      }
    }

    return paths[src][des];
  }

}
