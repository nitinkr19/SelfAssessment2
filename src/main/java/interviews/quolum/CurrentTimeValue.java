package main.java.interviews.quolum;

import java.time.LocalDateTime;

public interface CurrentTimeValue {

  LocalDateTime getCurrentTime();

  void setCurrentTime(LocalDateTime localDateTime);

}
