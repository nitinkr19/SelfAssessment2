package test.java.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import main.java.practice.arrays.IslandProblems;
import org.junit.jupiter.api.Test;

class IslandProblemsTest {

  IslandProblems island = new IslandProblems();

  @Test
  void countIslands() {

    char[][] sea = new char[][]
        {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

    assertEquals(1, island.countIslands(sea));
  }

  @Test
  void countIslands12() {

    char[][] sea = new char[][]
        {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'1', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

    assertEquals(3, island.countIslands(sea));
  }

  @Test
  void countUniqueIslands() {

    char[][] sea = new char[][]
        {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '1', '1'},
            {'0', '0', '0', '1', '1'}
        };
    assertEquals(1, island.countUniqueIslands(sea));
  }

  @Test
  void countUniqueIslands2() {

    char[][] sea = new char[][]
        {
            {'1', '1', '0', '1', '1'},
            {'1', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '1'},
            {'1', '1', '0', '1', '1'}
        };
    assertEquals(3, island.countUniqueIslands(sea));
  }

  @Test
  void captureRegions() {

    char[][] region = new char[][]
        {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
    System.out.println(island.gridToString(region));
    char[][] regionFinal = island.captureRegions(region);
    System.out.println(island.gridToString(regionFinal));

  }

  @Test
  void captureRegions12() {

    char[][] region = new char[][]
        {
            {'O', 'O', 'O'},
            {'O', 'O', 'O'},
            {'O', 'O', 'O'}
        };
    System.out.println(island.gridToString(region));
    char[][] regionFinal = island.captureRegions(region);
    System.out.println(island.gridToString(regionFinal));

  }

  @Test
  void captureRegions2() {

    char[][] region = new char[][]
        {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
    System.out.println(island.gridToString(region));
    char[][] regionFinal = island.captureRegions2(region);
    System.out.println(island.gridToString(regionFinal));

  }

  @Test
  void captureRegions22() {

    char[][] region = new char[][]
        {
            {'O', 'O', 'O'},
            {'O', 'O', 'O'},
            {'O', 'O', 'O'}
        };
    System.out.println(island.gridToString(region));
    char[][] regionFinal = island.captureRegions2(region);
    System.out.println(island.gridToString(regionFinal));

  }

  @Test
  void countGroups() {

    int val = IslandProblems.countGroups(Arrays.asList("1100", "1110", "0110", "0001"));
    System.out.println(val);
  }
}