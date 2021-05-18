package main.java.atlassian;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class VoterBaseImplTest {

  private VoterBase voterBase;

  @Test
  void findWinner1() {
    voterBase = new VoterBaseImpl();

    List<String> votes = Arrays.asList("B", "A", "B", "A", "C", "D", "B", "A");

    String winner = voterBase.findWinner(votes);
    Assert.assertEquals("A", winner);

  }

  /*
    Empty List : We can throw Exception or currently null
    Null
    Same Candidate in list
    Case insensitive
    Duplicate winners : Exception

    Every voters : list of 3 candidates
    V1 - list : 3P 2P 1P
    V2
    V3
   */
}