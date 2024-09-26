package main.java.practice.leetcode;

import java.util.Arrays;

public class LeetCodeMedium {

  /*
    On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

    "G": go straight 1 unit;
    "L": turn 90 degrees to the left;
    "R": turn 90 degrees to the right.
    The robot performs the instructions given in order, and repeats them forever.

    Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
  */

  /*

  Example 1:

    Input: instructions = "GGLLGG"
    Output: true
    Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
    When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.

  Example 2:

    Input: instructions = "GG"
    Output: false
    Explanation: The robot moves north indefinitely.

  Example 3:

    Input: instructions = "GL"
    Output: true
    Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...

  */
  public boolean isRobotBounded(String instructions) {

    int[][] directions = new int[][]{
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    int x = 0, y = 0;
    int ind = 0;//north
    for (int i = 0; i < instructions.length(); i++) {
      char c = instructions.charAt(i);

      if (c == 'L') {
        ind = (ind + 3) % 4;
      } else if (c == 'R') {
        ind = (ind + 1) % 4;
      } else {

        x += directions[ind][0];
        y += directions[ind][1];

      }
    }
    return (x == 0 && y == 0) || ind != 0;
  }

  public int maxAreaInCakeCuts(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);

    int hMaxDiff = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length-1]);
    int vMaxDiff = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length-1]);

    for (int i = 1; i < horizontalCuts.length; i++) {
      hMaxDiff = Math.max(hMaxDiff, horizontalCuts[i] - horizontalCuts[i - 1]);
    }

    for (int i = 1; i < verticalCuts.length; i++) {
      vMaxDiff = Math.max(vMaxDiff, verticalCuts[i] - verticalCuts[i - 1]);
    }

    return hMaxDiff * vMaxDiff;
  }

}
