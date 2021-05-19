package main.java.games;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConnectFourTest {

  @Test
  void testToString() {
  }

  @Test
  void run() {

    int h = 6;
    int w = 7;
    ConnectFour connectFour = new ConnectFour(h, w);

    int[] plays = new int[]{0,1,2,3,4,5,3,4,5,6,5,6,3,4,4,5,3,5,3,5,3,5,3};
    connectFour.run(plays);
  }
}