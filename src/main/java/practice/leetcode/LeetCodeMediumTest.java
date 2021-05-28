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
}