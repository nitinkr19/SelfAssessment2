package main.java.graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphProblems implements IGraph {

  @Override
  public Double evaluateDivision(
      List<List<String>> equations, List<Double> values, List<String> query
  ) {

    Graph graph = buildGraph(equations, values);
    String src = query.get(0);
    String des = query.get(1);
    Set<String> visited = new HashSet<>();
    return getCalculatedValue(graph.getEdges(), src, des, visited);
  }

  private Double getCalculatedValue(
      Map<String, Map<String, Double>> graph,
      String src, String des,
      Set<String> visited
  ) {
    if (!graph.containsKey(src)) {
      return -1.0;
    }

    if (graph.get(src).containsKey(des)) {
      return graph.get(src).get(des);
    }

    visited.add(src);
    for (Map.Entry<String, Double> neighbor : graph.get(src).entrySet()) {
      if (!visited.contains(neighbor.getKey())) {
        double val = getCalculatedValue(graph, neighbor.getKey(), des, visited);
        if (val != -1) {
          return val * neighbor.getValue();
        }
      }
    }

    return -1.0;
  }


  private Graph buildGraph(List<List<String>> equations, List<Double> values) {

    Graph graph = new Graph();
    String u, v;
    int i = 0;
    for (List<String> equation : equations) {
      u = equation.get(0);
      v = equation.get(1);

      graph.addEdgeDirected(u, v, values.get(i));
      graph.addEdgeDirected(v, u, 1 / values.get(i));
      i++;
    }

    return graph;
  }

}
