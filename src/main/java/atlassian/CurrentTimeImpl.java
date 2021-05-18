package main.java.atlassian;

public class CurrentTimeImpl implements CurrentTime {

  private long currentTime;

  public CurrentTimeImpl(long currentTime) {
    this.currentTime = currentTime;
  }

  @Override
  public long getCurrentTime() {
    return currentTime;
  }

  @Override
  public void setCurrentTime(long currentTime) {
    this.currentTime = currentTime;
  }

}
