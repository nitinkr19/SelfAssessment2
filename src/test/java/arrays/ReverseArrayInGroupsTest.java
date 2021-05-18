package test.java.arrays;

import java.util.ArrayList;
import java.util.List;
import main.java.arrays.ReverseArrayInGroups;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseArrayInGroupsTest {

  private ReverseArrayInGroups reverseArrayInGroups;
  private List<Integer> list;
  private int groupSize;

  @BeforeEach
  void setUp() {
    list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    groupSize = 4;
  }

  @Test
  void reverseInGroups1() {
    reverseArrayInGroups = new ReverseArrayInGroups(list, groupSize);
    reverseArrayInGroups.reverseInGroups();
    List<Integer> modifiedList = reverseArrayInGroups.list();
    Assert.assertEquals(4, modifiedList.get(0), 0);
    Assert.assertEquals(3, modifiedList.get(1), 0);
    Assert.assertEquals(2, modifiedList.get(2), 0);
    Assert.assertEquals(1, modifiedList.get(3), 0);
    Assert.assertEquals(8, modifiedList.get(4), 0);
    Assert.assertEquals(7, modifiedList.get(5), 0);
    Assert.assertEquals(6, modifiedList.get(6), 0);
    Assert.assertEquals(5, modifiedList.get(7), 0);
  }

  @Test
  void reverseInGroups2() {
    reverseArrayInGroups = new ReverseArrayInGroups(list, 10);
    reverseArrayInGroups.reverseInGroups();
    List<Integer> modifiedList = reverseArrayInGroups.list();
    Assert.assertEquals(8, modifiedList.get(0), 0);
    Assert.assertEquals(7, modifiedList.get(1), 0);
    Assert.assertEquals(6, modifiedList.get(2), 0);
    Assert.assertEquals(5, modifiedList.get(3), 0);
    Assert.assertEquals(4, modifiedList.get(4), 0);
    Assert.assertEquals(3, modifiedList.get(5), 0);
    Assert.assertEquals(2, modifiedList.get(6), 0);
    Assert.assertEquals(1, modifiedList.get(7), 0);
  }

  @Test
  void reverseInGroups3() {
    reverseArrayInGroups = new ReverseArrayInGroups(list, 1);
    reverseArrayInGroups.reverseInGroups();
    List<Integer> modifiedList = reverseArrayInGroups.list();
    Assert.assertEquals(1, modifiedList.get(0), 0);
    Assert.assertEquals(2, modifiedList.get(1), 0);
    Assert.assertEquals(3, modifiedList.get(2), 0);
    Assert.assertEquals(4, modifiedList.get(3), 0);
    Assert.assertEquals(5, modifiedList.get(4), 0);
    Assert.assertEquals(6, modifiedList.get(5), 0);
    Assert.assertEquals(7, modifiedList.get(6), 0);
    Assert.assertEquals(8, modifiedList.get(7), 0);
  }

  @Test
  void reverseInGroups4() {
    reverseArrayInGroups = new ReverseArrayInGroups(list, 3);
    reverseArrayInGroups.reverseInGroups();
    List<Integer> modifiedList = reverseArrayInGroups.list();
    Assert.assertEquals(3, modifiedList.get(0), 0);
    Assert.assertEquals(2, modifiedList.get(1), 0);
    Assert.assertEquals(1, modifiedList.get(2), 0);
    Assert.assertEquals(6, modifiedList.get(3), 0);
    Assert.assertEquals(5, modifiedList.get(4), 0);
    Assert.assertEquals(4, modifiedList.get(5), 0);
    Assert.assertEquals(8, modifiedList.get(6), 0);
    Assert.assertEquals(7, modifiedList.get(7), 0);
  }
}