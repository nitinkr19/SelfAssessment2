package main.java.interviews.atlassian;

/*
Imagine we are building an application that is used by many different customers. We want to avoid one customer being able to overload the system by sending too many requests, so we enforce a per-customer rate limit. The rate limit is defined as:  “Each customer can make X requests per Y seconds” boolean rateLimit(int customerId) 
 */
public interface Customer {

  /*
    Allow MAX 10 requests per second.
   */
  boolean rateLimit(int customerId);

}
