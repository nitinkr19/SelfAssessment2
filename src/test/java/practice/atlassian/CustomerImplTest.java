package test.java.practice.atlassian;

import main.java.interviews.atlassian.CurrentTime;
import main.java.interviews.atlassian.CurrentTimeImpl;
import main.java.interviews.atlassian.Customer;
import main.java.interviews.atlassian.CustomerImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CustomerImplTest {

  private Customer customer;
  private CurrentTime currentTime;

  public void setUp() {

//    Map<Integer, List<Request>> requestMap =
//        new HashMap<Integer, List<Request>>() {{
//          // 11 requests for customer Id : 1
//          put(
//              1,
//              Arrays.asList(
//                  new Request(1, 1),
//                  new Request(1, 1),
//                  new Request(1, 1),
//                  new Request(1, 1),
//                  new Request(1, 1),
//                  new Request(1, 1),
//                  new Request(1, 1),
//                  new Request(1, 1),
//                  new Request(1, 1),
//                  new Request(1, 1),
//                  new Request(1, 1)
//              )
//          );
//          // 9 requests for customer Id : 2
//          put(
//              2,
//              Arrays.asList(
//                  new Request(2, 1),
//                  new Request(2, 1),
//                  new Request(2, 1),
//                  new Request(2, 1),
//                  new Request(2, 1),
//                  new Request(2, 1),
//                  new Request(2, 1),
//                  new Request(2, 1),
//                  new Request(2, 1)
//              )
//          );
//        }};

    currentTime = new CurrentTimeImpl(System.currentTimeMillis());
    customer = new CustomerImpl(currentTime);
  }

  @Test
  void rateLimit() throws InterruptedException {
    setUp();
    Assert.assertFalse(customer.rateLimit(1));
    Assert.assertFalse(customer.rateLimit(1));
    Assert.assertFalse(customer.rateLimit(1));

    Assert.assertFalse(customer.rateLimit(1));
    Assert.assertFalse(customer.rateLimit(1));
    Assert.assertFalse(customer.rateLimit(1));

    Assert.assertFalse(customer.rateLimit(1));
    Assert.assertFalse(customer.rateLimit(1));
    Assert.assertFalse(customer.rateLimit(1));

    Assert.assertFalse(customer.rateLimit(1));

    Assert.assertTrue(customer.rateLimit(1));

    currentTime.setCurrentTime(System.currentTimeMillis() + 1000);

    Assert.assertFalse(customer.rateLimit(1));
    Assert.assertFalse(customer.rateLimit(1));
    Assert.assertFalse(customer.rateLimit(1));
  }

}