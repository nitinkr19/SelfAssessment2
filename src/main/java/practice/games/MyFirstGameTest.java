package main.java.practice.games;

import org.junit.jupiter.api.Test;

class MyFirstGameTest {

  @Test
  void testToString() {
  }

  @Test
  void run() {

    int h = 6;
    int w = 7;
    MyFirstGame myFirstGame = new MyFirstGame(h, w);

    int[] plays = new int[]{0,1,2,3,4,5,3,4,5,6,5,6,3,4,4,5,3,5,3,5,3,5,3};
    myFirstGame.run(plays);
  }
}