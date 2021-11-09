package cs2.adt

class BSTPriorityQueue[A <% Ordered[A]] extends PriorityQueue[A] {
  private var bst = new BinarySearchTree[A]()

  def add(elem:A):Unit = bst.insert(elem)
  def get():A = bst.removeMax()
  def peek():A = bst.getMax()
  def isEmpty():Boolean = bst.isEmpty()
}