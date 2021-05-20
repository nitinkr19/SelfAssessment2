package main.java.practice.graphs;

import java.util.HashMap;
import java.util.Map;

public class Graph {

  private final Map<String, Map<String, Double>> edges;
  private int vertices;

  public Graph(int vertices) {
    this.vertices = vertices;
    this.edges = new HashMap<>();
  }

  public Graph() {
    this.edges = new HashMap<>();
  }

  public void addEdgeDirected(String v, String w, Double val) {
    this.edges.putIfAbsent(v, new HashMap<>());
    this.edges.get(v).put(w, val);
  }

  public void addEdge(String v, String w, Double val) {
    edges.getOrDefault(v, new HashMap<>()).put(w, val);
    edges.getOrDefault(w, new HashMap<>()).put(v, val);
  }

  public Map<String, Map<String, Double>> getEdges() {
    return this.edges;
  }

}
