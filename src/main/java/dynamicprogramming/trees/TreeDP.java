package main.java.dynamicprogramming.trees;

import main.java.trees.Node;

public class TreeDP implements ITreeDP {

  int res = Integer.MIN_VALUE;

  @Override
  public int diameter(Node<Integer> root) {

    res = Integer.MIN_VALUE;
    findDiameter(root);
    return res;
  }

  @Override
  public int maxPathSum(Node<Integer> root) {

    res = Integer.MIN_VALUE;
    findMaxPathSum(root);
    return res;
  }

  @Override
  public int maxPathSumLeafToLeaf(Node<Integer> root) {
    res = Integer.MIN_VALUE;
    findMaxPathSumLeafToLeaf(root);
    return res;
  }

  private int findMaxPathSumLeafToLeaf(Node<Integer> root) {

    //BC
    if (root == null) {
      return 0;
    }

    if (root.getLeft() == null && root.getRight() == null) {
      return root.getData();
    }

    //H
    int left = findMaxPathSumLeafToLeaf(root.getLeft());
    int right = findMaxPathSumLeafToLeaf(root.getRight());

    //I
    if (root.getLeft() != null && root.getRight() != null) {
      int temp = Math.max(left, right) + root.getData();
      res = Math.max(root.getData() + left + right, res);
      return temp;
    }

    return root.getLeft() == null ? right + root.getData() : left + root.getData();
  }

  private int findMaxPathSum(Node<Integer> root) {

    //BC
    if (root == null) {
      return 0;
    }

    //H
    int left = findMaxPathSum(root.getLeft());
    int right = findMaxPathSum(root.getRight());

    //I
    int temp = Math.max(
        Math.max(left, right) + root.getData(),
        root.getData()
    );
    int ans = Math.max(temp, root.getData() + left + right);
    res = Math.max(ans, res);

    return temp;
  }

  private int findDiameter(Node<Integer> root) {

    //BC
    if (root == null) {
      return 0;
    }

    //H
    int left = findDiameter(root.getLeft());
    int right = findDiameter(root.getRight());

    //I
    int temp = Math.max(left, right) + 1;
    int ans = Math.max(temp, 1 + left + right);
    res = Math.max(res, ans);

    return temp;
  }
}
