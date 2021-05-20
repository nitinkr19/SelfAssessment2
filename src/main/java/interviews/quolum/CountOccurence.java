package main.java.interviews.quolum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CountOccurence {

  /*
    Create a class with two methods: inc() and count().
    Count should return the number of times that inc was called in the last one minutes
   */

  public final CurrentTimeValue currentTimeValue;
  public List<LocalDateTime> listOfTimes;
  public int counter;

  public CountOccurence(
      CurrentTimeValue currentTimeValue
  ) {
    listOfTimes = new ArrayList<>();
    this.currentTimeValue = currentTimeValue;
  }

  public void inc() {
    listOfTimes.add(currentTimeValue.getCurrentTime());
  }

  public int count() {

    counter = 0;
    LocalDateTime timeBeforeAMinute = currentTimeValue.getCurrentTime().minusMinutes(1);
    for (LocalDateTime time : listOfTimes) {
      if (time.isAfter(timeBeforeAMinute)) {
        counter++;
      } else {
        listOfTimes.remove(time);
      }
    }
    return counter;
  }

}
