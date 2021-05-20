package main.java.interviews.atlassian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerImpl implements Customer {

  private static final int MAX_ALLOWED_REQUESTS = 10;
  private static final int MILLISECONDS_TO_LIMIT_REQUESTS = 1000;

  private final Map<Integer, List<Request>> requestMap = new HashMap<>();

  private final CurrentTime currentTime;

  public CustomerImpl(CurrentTime currentTime) {
    this.currentTime = currentTime;
  }

  /*
   Time Complexity O(N)
   -- p customers
   Space Complexity : O(N X p)

   Less Complexity

   customerId, count, earliestTimestamp
   1,1, 1 ( 1 milis)
   1,2, 1 ( 2 milis)

   1,n-1, 1 ( 1000 milis)
   1,n, 1001 ( 1001 milis)
   */
  @Override
  public boolean rateLimit(int customerId) {

    List<Request> requestList = requestMap.get(customerId);

    if (requestList == null) {
      requestList = new ArrayList<>();
    }

    long currentTimeInMilliseconds = currentTime.getCurrentTime();
    requestList.add(new Request(customerId, currentTimeInMilliseconds));
    requestMap.put(customerId, requestList);

    long requestsInLastOneSecond = requestList
        .stream()
        .filter(
            request ->
                (currentTimeInMilliseconds - request.getTimestampInMilliseconds())
                    <= MILLISECONDS_TO_LIMIT_REQUESTS
        )
        .count();

    return requestsInLastOneSecond > MAX_ALLOWED_REQUESTS;
  }
}
