package cs2.adt

class LinkedPriorityQueue[A <% Ordered[A]] extends PriorityQueue[A] {
  private class Node(var data:A, var next:Node)
  private var head:Node = null

  def add(elem:A):Unit = { head = new Node(elem, head) }
  def get():A = ???
  def peek():A = {
    ???
  }
  def isEmpty():Boolean = { head == null }

}