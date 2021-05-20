package main.java.interviews.atlassian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VoterBaseImpl implements VoterBase {

  private final Map<String, Integer> voteMap = new HashMap<>();

  @Override
  public String findWinner(List<String> votes) {

    String winner = null;
    int maxVoteCount = 0;

    for (String currentCandidate : votes) {

      int countForCurrentCandidate = voteMap.getOrDefault(currentCandidate, 0) + 1;
      voteMap.put(
          currentCandidate,
          countForCurrentCandidate
      );

      if (countForCurrentCandidate > maxVoteCount) {
        maxVoteCount = countForCurrentCandidate;
        winner = currentCandidate;
      }

    }

    return winner;
  }

  @Override
  public String findWinnerWithPreferentialVoting(
      Map<String, List<String>> voterChosenCandidateListMap
  ) {

    String winner = null;
    int maxVoteCount = 0;
    Set<Entry<String, List<String>>> entries = voterChosenCandidateListMap.entrySet();
    for (Map.Entry entry : entries) {
      List<String> candidates = (List<String>) entry.getValue();
      int points = candidates.size();
      for (String candidate : candidates) {
        String currentCandidate = candidate.toLowerCase();
        int countForCurrentCandidate = voteMap.getOrDefault(currentCandidate, 0) + points;
        voteMap.put(currentCandidate, countForCurrentCandidate);
        points--;

        if (countForCurrentCandidate > maxVoteCount) {
          maxVoteCount = countForCurrentCandidate;
          winner = currentCandidate;
        }
      }

    }
    return winner;
  }
}
