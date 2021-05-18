package main.java.atlassian;

import java.util.List;
import java.util.Map;

public interface VoterBase {

  String findWinner(List<String> votes);

  String findWinnerWithPreferentialVoting(Map<String, List<String>> voterChosenCandidateListMap);

}
