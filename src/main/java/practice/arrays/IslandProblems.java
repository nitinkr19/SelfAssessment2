package main.java.practice.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.util.Pair;

public class IslandProblems {

  static Set<Integer> completed = new HashSet<>();
  private boolean isBoundaryInclusive = false;

  public static int countGroups(List<String> related) {

    int m = related.size();
    int count = 0;

    for (int i = 0; i < m; i++) {
      if (!completed.contains(i)) {
        dfs(related, i);
        count++;
      }
    }

    return count;
  }

  private static void dfs(List<String> related, int i) {

    Queue<Integer> q = new LinkedList<>();
    q.add(i);
    while (!q.isEmpty()) {
      int curr = q.poll();
      if (completed.contains(curr)) {
        return;
      }
      for (int neighbor = 0; neighbor < related.get(curr).length(); neighbor++) {
        if (curr != neighbor && related.get(curr).charAt(neighbor) == '1') {
          if(!completed.contains(neighbor)){
            q.add(neighbor);
          }
        }
      }
      completed.add(curr);
    }

  }

  public String gridToString(char[][] grid) {
    return
        IntStream.range(1, grid[0].length + 1)
            .mapToObj(Integer::toString)
            .collect(Collectors.joining())
            + "\n" +
            Arrays.stream(grid)
                .map(String::new)
                .collect(Collectors.joining("\n"));
  }

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

  public char[][] captureRegions(char[][] region) {

    int m = region.length;
    int n = region[0].length;

    boolean[][] visited = new boolean[m][n];
    char[][] regionCopy;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (region[i][j] == 'O') {
          Set<Pair<Integer, Integer>> currentRegion = new HashSet<>();
          regionCopy = Arrays.stream(region).map(char[]::clone).toArray(char[][]::new);
          findRegions(region, i, j, m, n, visited, currentRegion, regionCopy);
          if (!currentRegion.isEmpty()) {
            region = regionCopy;
          }
        }

      }
    }
    return region;
  }

  private void findRegions(
      char[][] region,
      int i, int j,
      int m, int n,
      boolean[][] visited,
      Set<Pair<Integer, Integer>> currentRegion,
      char[][] regionCopy
  ) {

    if (valid(i, j, m, n) && !visited[i][j] && region[i][j] == 'O') {
      visited[i][j] = true;
      currentRegion.add(new Pair<>(i, j));
      regionCopy[i][j] = 'X';
      findRegions(region, i - 1, j, m, n, visited, currentRegion, regionCopy);
      findRegions(region, i, j - 1, m, n, visited, currentRegion, regionCopy);
      findRegions(region, i, j + 1, m, n, visited, currentRegion, regionCopy);
      findRegions(region, i + 1, j, m, n, visited, currentRegion, regionCopy);
      if (boundary(i, j, m, n)) {
        currentRegion.clear();
      }
    }

  }

  public char[][] captureRegions2(char[][] region) {

    int m = region.length;
    int n = region[0].length;

    boolean[][] visited = new boolean[m][n];
    char[][] regionCopy;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (region[i][j] == 'O') {
          isBoundaryInclusive = false;
          regionCopy = Arrays.stream(region).map(char[]::clone).toArray(char[][]::new);
          findRegions(region, i, j, m, n, visited, regionCopy);
          if (!isBoundaryInclusive) {
            region = regionCopy;
          }
        }

      }
    }
    return region;
  }

  private void findRegions(
      char[][] region,
      int i, int j,
      int m, int n,
      boolean[][] visited,
      char[][] regionCopy
  ) {

    if (valid(i, j, m, n) && !visited[i][j] && !isBoundaryInclusive && region[i][j] == 'O') {
      visited[i][j] = true;
      regionCopy[i][j] = 'X';
      findRegions(region, i - 1, j, m, n, visited, regionCopy);
      findRegions(region, i, j - 1, m, n, visited, regionCopy);
      findRegions(region, i, j + 1, m, n, visited, regionCopy);
      findRegions(region, i + 1, j, m, n, visited, regionCopy);
      if (boundary(i, j, m, n)) {
        isBoundaryInclusive = true;
      }
    }

  }

  private boolean boundary(int i, int j, int m, int n) {
    return i == 0 || j == 0 || i == m - 1 || j == n - 1;
  }

}
