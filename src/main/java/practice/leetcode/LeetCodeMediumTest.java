package main.java.practice.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LeetCodeMediumTest {

  LeetCodeMedium leetCodeMedium = new LeetCodeMedium();

  @Test
  void isRobotBounded() {

    assertEquals(true, leetCodeMedium.isRobotBounded("GGLLGG"));
    assertEquals(false, leetCodeMedium.isRobotBounded("GG"));
    assertEquals(true, leetCodeMedium.isRobotBounded("GL"));
    assertEquals(true, leetCodeMedium.isRobotBounded("GLRLLGLL"));
  }

  @Test
  void maxAreaInCakeCuts() {

    assertEquals(9,leetCodeMedium.maxAreaInCakeCuts(5,4,new int[]{3}, new int[]{3}));
    assertEquals(4,leetCodeMedium.maxAreaInCakeCuts(5,4,new int[]{1,2,4}, new int[]{1,3}));
    assertEquals(6,leetCodeMedium.maxAreaInCakeCuts(5,4,new int[]{3,1}, new int[]{1}));
  }
}