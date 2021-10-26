package cs2.adt

class DoublyLinkedSeq[A] extends Seq[A] {
  private class Node(var data:A, var prev:Node, var next:Node)

  private var hed:Node = null
  private var lst:Node = null
  private var len:Int = 0

  def get(idx:Int):A = ???
  def set(idx:Int, elem:A):Unit = ???
  def insert(idx:Int, elem:A):Unit = ???
  def remove(idx:Int):A = ???
  def length():Int = ???
}