package main.java.interviews.atlassian;


public class Request {

  private final int customerId;

  private final long timestampInMilliseconds;

  public Request(int customerId, long timestampInMilliseconds) {
    this.customerId = customerId;
    this.timestampInMilliseconds = timestampInMilliseconds;
  }

  public long getTimestampInMilliseconds() {
    return this.timestampInMilliseconds;
  }

  public int getCustomerId() {
    return this.customerId;
  }

}
