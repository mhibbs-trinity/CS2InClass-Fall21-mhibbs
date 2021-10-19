package cs2.adt

class LinkedStack[A] extends Stack[A] {
  private class Node(var data:A, var next:Node) { }
  private var head:Node = null

  def push(elem:A):Unit = {
    head = new Node(elem, head)
  }
  def pop():A = {
    val tmp = head.data
    head = head.next
    tmp
  }
  def peek():A = head.data
  def isEmpty():Boolean = head == null
}