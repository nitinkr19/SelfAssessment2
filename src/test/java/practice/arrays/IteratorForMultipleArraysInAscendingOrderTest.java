package test.java.practice.arrays;

import java.util.Arrays;
import java.util.List;
import main.java.practice.arrays.IteratorForMultipleArraysInAscendingOrder;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IteratorForMultipleArraysInAscendingOrderTest {

  private IteratorForMultipleArraysInAscendingOrder iterator;

  @BeforeEach
  void setUp() {
    List<List<Integer>> listsOfList =
        Arrays.asList(
            Arrays.asList(1, 5, 7),
            Arrays.asList(2, 3, 10),
            Arrays.asList(4, 6, 9)
        );
    iterator = new IteratorForMultipleArraysInAscendingOrder(listsOfList);
  }

  @Test
  void testNext() {
    Assert.assertEquals(1, iterator.next(), 0);
    Assert.assertTrue(iterator.hasNext());
    Assert.assertEquals(2, iterator.next(), 0);
    Assert.assertEquals(3, iterator.next(), 0);
    Assert.assertEquals(4, iterator.next(), 0);
    Assert.assertEquals(5, iterator.next(), 0);
    Assert.assertEquals(6, iterator.next(), 0);
  }

}