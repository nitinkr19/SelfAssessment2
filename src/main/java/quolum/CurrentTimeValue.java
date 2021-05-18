package main.java.quolum;

import java.time.LocalDateTime;

public interface CurrentTimeValue {

  LocalDateTime getCurrentTime();

  void setCurrentTime(LocalDateTime localDateTime);

}
