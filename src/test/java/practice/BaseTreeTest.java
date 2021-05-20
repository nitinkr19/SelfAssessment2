package test.java.practice;

import main.java.practice.trees.Node;
import org.junit.Before;

public class BaseTreeTest {

  public Node<Integer> node;

  public BaseTreeTest() {
    setUp();
  }

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

}
