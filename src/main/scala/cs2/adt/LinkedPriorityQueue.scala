package cs2.adt

class LinkedPriorityQueue[A <% Ordered[A]] extends PriorityQueue[A] {
  private class Node(var data:A, var next:Node)
  private var head:Node = null

  def add(elem:A):Unit = {
    if(head == null || elem > head.data) {
      head = new Node(elem, head)
    } else {
      var rover = head
      while(rover.next != null && rover.next.data > elem) {
        rover = rover.next
      }
      rover.next = new Node(elem, rover.next)
    }
  }
  def get():A = {
    val ret = head.data
    head = head.next
    ret
  }
  def peek():A = head.data

  /*
  def add(elem:A):Unit = { head = new Node(elem, head) }
  def get():A = {
    //Beliefs
    var biggest = head.data
    var obb:Node = null
    //Iterate variables
    var rover = head
    var obr:Node = null

    while(rover != null) {
      if(rover.data > biggest) {
        biggest = rover.data
        obb = obr
      }
      obr = rover
      rover = rover.next
    }
    if(obb != null) {
      obb.next = obb.next.next
    } else { //head is the biggest
      head = head.next
    }
    biggest
  }
  def peek():A = {
    var biggest = head.data
    var rover = head.next
    while(rover != null) {
      if(rover.data > biggest) biggest = rover.data
      rover = rover.next
    }
    biggest
  }
  */
  def isEmpty():Boolean = { head == null }

}