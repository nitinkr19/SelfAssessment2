package main.java.trees;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class InsertionInBinaryTreeTest {

  InsertionInBinaryTree insertion;
  private Node<Integer> node;

  @Before
  public void setUp() {

    node = new Node<>(1);
    node.left = new Node(2);
    node.right = new Node(3);
    node.left.left = new Node(4);
    node.left.right = new Node(5);
    node.right.left = new Node(6);

    node.right.left.right = new Node(7);

    insertion = new InsertionInBinaryTree();
  }


  @Test
  public void insertNodeInTree() {
    setUp();
    Traversal traversal = new Traversal();
    traversal.preOrder(node);
    System.out.println();
    insertion.insertNodeInTree(node, 10);
    traversal.preOrder(node);
  }
}