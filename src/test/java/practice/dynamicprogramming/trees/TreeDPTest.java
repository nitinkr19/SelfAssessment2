package test.java.practice.dynamicprogramming.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.practice.dynamicprogramming.trees.ITreeDP;
import main.java.practice.dynamicprogramming.trees.TreeDP;
import main.java.practice.trees.Node;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class TreeDPTest {

  private final ITreeDP treeDP = new TreeDP();
  private Node<Integer> node;

  @Before
  public void setUp() {

    node = new Node<>(1);
    node.setLeft(new Node<>(2));
    node.setRight(new Node<>(3));

    node.getLeft().setLeft(new Node<>(-4));
    node.getLeft().setRight(new Node<>(-5));
    node.getRight().setLeft(new Node<>(6));

    node.getRight().getLeft().setRight(new Node<>(7));
  }

  @Test
  void diameter() {
    setUp();
    assertEquals(6, treeDP.diameter(node));
  }

  @Test
  void maxPathSum() {
    setUp();
    assertEquals(19, treeDP.maxPathSum(node));
  }

  @Test
  void maxPathSumLeafToLeaf() {
    setUp();
    assertEquals(15, treeDP.maxPathSumLeafToLeaf(node));
  }
}