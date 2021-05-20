package main.java.interviews.quolum;

import java.time.LocalDateTime;

public class CurrentTimeValueImpl implements CurrentTimeValue {

  private LocalDateTime localDateTime;

  public CurrentTimeValueImpl(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }

  @Override
  public LocalDateTime getCurrentTime() {
    return this.localDateTime;
  }

  @Override
  public void setCurrentTime(LocalDateTime l) {
    localDateTime = l;
  }
}
