package main.java.games;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConnectFour {

  public static final char BLANK_CHAR = '.';
  private static final char[] PLAYERS = {'R', 'B'};
  private final int height, width;
  private final char[][] grid;
  private int lastCol = -1;
  private int lastRow = -1;

  public ConnectFour(int h, int w) {
    this.height = h;
    this.width = w;
    this.grid = new char[h][w];

    for (int i = 0; i < h; i++) {
      grid[i] = new char[w];
      Arrays.fill(grid[i], BLANK_CHAR);
    }
  }

  public String toString() {
    return IntStream.range(0, width)
        .mapToObj(Integer::toString).collect(Collectors.joining())
        + "\n"
        + Arrays.stream(grid)
        .map(String::new)
        .collect(Collectors.joining("\n"));
  }

  public boolean isWinningPlay() {

    if (lastCol == -1) {
      return false;
    }

    char player = grid[lastRow][lastCol];

    String plays = String.format("%c%c%c%c", player, player, player, player);

    return
        contains(horizontal(), plays)
            || contains(vertical(), plays)
            || contains(diagonal(), plays)
            || contains(revDiagonal(), plays);

  }

  private String horizontal() {
    return new String(grid[lastRow]);
  }

  private String vertical() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < height; i++) {
      s.append(grid[i][lastCol]);
    }
    return s.toString();
  }

  private String diagonal() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < height; i++) {
      int w = lastCol + lastRow - height;

      if (w >= 0 && w < width) {
        s.append(grid[i][w]);
      }
    }
    return s.toString();
  }

  private String revDiagonal() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < height; i++) {
      int w = lastCol - lastRow + height;

      if (w >= 0 && w < width) {
        s.append(grid[i][w]);
      }
    }
    return s.toString();
  }

  private boolean contains(String s, String pattern) {
    return s.contains(pattern);
  }

  public void playTurn(int player, int playTurn) {

    if (!(playTurn >= 0 && playTurn <= width)) {
      System.out.println("Invalid move!");
      return;
    }

    for (int i = height - 1; i >= 0; i--) {
      if (grid[i][playTurn] == BLANK_CHAR) {
        grid[i][playTurn] = PLAYERS[player];
        lastRow = i;
        lastCol = playTurn;
        return;
      }
    }

    System.out.println("Column : " + playTurn + " is full!");
  }

  public void run(int[] playTurns) {

    int moves = height * width;

    System.out.println("Valid Moves : 0-" + (width - 1) + " to choose a col");
    System.out.println(this);

    int turn = 0;
    for (int player = 0; moves-- >= 0; player = 1 - player) {

      if(turn < playTurns.length) {
        playTurn(player, playTurns[turn++]);
        System.out.println(this);

        if (isWinningPlay()) {
          System.out.println(PLAYERS[player] + " wins!!!");
          return;
        }
      }

    }

    System.out.println("Game over, no winner, pls try again!");
  }


}
