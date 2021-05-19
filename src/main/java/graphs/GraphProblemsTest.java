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

    // a/b -> 2
    // b/c -> 3
    // ??? a/c -> 6 ???
    // a/e -> 1.5
    // e/c -> 2.5
    List<String> equation = new ArrayList<>();
    equation.add("a");
    equation.add("e");
    equations.add(equation);
    equation = new ArrayList<>();
    equation.add("e");
    equation.add("c");
    equations.add(equation);
    equation = new ArrayList<>();
    equation.add("a");
    equation.add("b");
    equations.add(equation);
    equation = new ArrayList<>();
    equation.add("b");
    equation.add("c");
    equations.add(equation);

    List<Double> values = new ArrayList<>();
    values.add(1.5);
    values.add(2.5);
    values.add(2.0);
    values.add(3.0);

    List<String> query = new ArrayList<>();
    query.add("a");
    query.add("c");
    assertEquals(3.75, graph.evaluateDivision(equations, values, query));

  }
}