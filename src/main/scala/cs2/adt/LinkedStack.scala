package cs2.adt

import java.util.EmptyStackException

class LinkedStack[A] extends Stack[A] {
  private class Node(var data:A, var next:Node) { }
  private var head:Node = null

  def push(elem:A):Unit = {
    head = new Node(elem, head)
  }
  def pop():A = {
    if(isEmpty()) throw new EmptyStackException()
    val tmp = head.data
    head = head.next
    tmp
  }
  def peek():A = {
    if(isEmpty()) throw new EmptyStackException()
    head.data
  }
  def isEmpty():Boolean = head == null
}