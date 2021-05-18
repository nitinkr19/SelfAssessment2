package main.java.trees;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionInBinaryTree {

  public void insertNodeInTree(Node root, Integer data) {

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node temp = queue.remove();

      if (temp.left == null) {
        temp.left = new Node(data);
        break;
      } else {
        queue.add(temp.left);
      }

      if (temp.right == null) {
        temp.right = new Node(data);
        break;
      } else {
        queue.add(temp.right);
      }

    }
  }

}