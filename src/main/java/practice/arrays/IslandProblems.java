package main.java.practice.arrays;

import java.util.HashSet;
import java.util.Set;
import javafx.util.Pair;

public class IslandProblems {

  //1 - land
  //0 - sea
  public int countIslands(char[][] sea) {

    int m = sea.length;
    int n = sea[0].length;
    int count = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (sea[i][j] == '1') {
          calculateAreaOfIslands(sea, i, j, m, n);
          count++;
        }

      }
    }
    return count;
  }

  private int calculateAreaOfIslands(char[][] sea, int i, int j, int m, int n) {

    if (valid(i, j, m, n) && sea[i][j] == '1') {
      sea[i][j] = '0';
      return 1
          + calculateAreaOfIslands(sea, i - 1, j, m, n)
          + calculateAreaOfIslands(sea, i, j - 1, m, n)
          + calculateAreaOfIslands(sea, i, j + 1, m, n)
          + calculateAreaOfIslands(sea, i + 1, j, m, n);
    }
    return 0;
  }

  private boolean valid(int i, int j, int m, int n) {
    return i >= 0 && i < m && j >= 0 && j < n;
  }

  public int countUniqueIslands(char[][] sea) {

    int m = sea.length;
    int n = sea[0].length;

    Set<Set<Pair<Integer, Integer>>> uniqueIslands = new HashSet<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (sea[i][j] == '1') {
          Set<Pair<Integer, Integer>> currentIsland = new HashSet<>();
          findIslands(sea, i, j, m, n, i, j, currentIsland);
          uniqueIslands.add(currentIsland);
        }

      }
    }
    return uniqueIslands.size();
  }

  private void findIslands(
      char[][] sea,
      int i, int j,
      int m, int n,
      int curRow, int curCol,
      Set<Pair<Integer, Integer>> currentIsland
  ) {

    if (valid(i, j, m, n) && sea[i][j] == '1') {
      currentIsland.add(new Pair<>(i - curRow, j - curCol));
      sea[i][j] = '0';
      findIslands(sea, i - 1, j, m, n, curRow, curCol, currentIsland);
      findIslands(sea, i, j - 1, m, n, curRow, curCol, currentIsland);
      findIslands(sea, i, j + 1, m, n, curRow, curCol, currentIsland);
      findIslands(sea, i + 1, j, m, n, curRow, curCol, currentIsland);
    }

  }

}
