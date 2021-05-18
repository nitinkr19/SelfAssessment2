package main.java.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class GraphProblemsTest {

  private final IGraph graph = new GraphProblems();

  @Test
  void evaluateDivision() {
    List<List<String>> equations = new ArrayList<>();

    List<String> equation = new ArrayList<>();
    equation.add("a");
    equation.add("b");
    equations.add(equation);
    equation = new ArrayList<>();
    equation.add("b");
    equation.add("c");
    equations.add(equation);

    List<Double> values = new ArrayList<>();
    values.add(2.0);
    values.add(3.0);

    List<String> query = new ArrayList<>();
    query.add("a");
    query.add("c");
    assertEquals(6, graph.evaluateDivision(equations, values, query));

  }
}