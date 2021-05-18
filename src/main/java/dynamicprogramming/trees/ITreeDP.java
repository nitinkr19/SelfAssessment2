package main.java.dynamicprogramming.trees;

import main.java.trees.Node;

public interface ITreeDP {

  int diameter(Node<Integer> root);

  int maxPathSum(Node<Integer> root);

  int maxPathSumLeafToLeaf(Node<Integer> root);

}
