package main.java.stack;

public class Stack<T> {

  int size;
  private Node head;

  public Stack() {
    head = null;
    size = 0;
  }

  public void push(T data) {

    Node oldHead = head;
    head = new Node();
    head.data = data;
    head.next = oldHead;
    size++;
  }

  public T pop() {

    if (head == null) {
      return null;
      //throw new Exception("Empty Stack Exception");
    }

    T data = head.data;
    head = head.next;
    size--;
    return data;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public T peek() {

    if (head == null) {
      return null;
    }

    return head.data;
  }

  public void display() {

    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public int getSize() {
    return this.size;
  }

  private class Node {

    T data;
    Node next;
  }

}
