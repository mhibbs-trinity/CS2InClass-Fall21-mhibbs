package cs2.adt

class LinkedQueue[A] extends Queue[A] {
  private class Node(var data:A, var next:Node) { }
  private var head:Node = null
  private var last:Node = null

  def enqueue(elem:A):Unit = {
    if(isEmpty()) {
      last = new Node(elem, null)
      head = last
    } else {
      last.next = new Node(elem, null)
      last = last.next
    }
  }
  def dequeue():A = {
    if(isEmpty()) throw new Exception("Empty Q can't dequeue")
    val tmp = head.data
    head = head.next
    if(head == null) last = null
    tmp
  }
  def peek():A = {
    if(isEmpty()) throw new Exception("Empty Q can't peek")
    head.data
  }
  def isEmpty():Boolean = {
    head == null
  }
}


