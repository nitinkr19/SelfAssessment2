package test.java.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}