package main.java.trees;

public class Node<T> {

  T data;
  Node<T> left;
  Node<T> right;

  public Node(T data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public T getData() {
    return data;
  }

  public Node<T> getLeft() {
    return this.left;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public Node<T> getRight() {
    return this.right;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }

}
