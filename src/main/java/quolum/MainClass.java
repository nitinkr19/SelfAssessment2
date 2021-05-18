package main.java.quolum;

import java.time.LocalDateTime;

public class MainClass {

  public static void main(String[] args) {

    CurrentTimeValue currentTimeValue =
        new CurrentTimeValueImpl(LocalDateTime.now().minusMinutes(1));

    CountOccurence countOccurence = new CountOccurence(currentTimeValue);

    countOccurence.inc();
    countOccurence.inc(); //list of 2 times : currenttime - 1 min

    System.out.println(countOccurence.count());
  }


}
