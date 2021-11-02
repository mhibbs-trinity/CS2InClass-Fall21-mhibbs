package cs2.adt

class BinarySearchTree[A <% Ordered[A]] {
  private class Node(var data:A, var left:Node, var right:Node) {
    def contains(elem:A):Boolean = {
      if(data <= elem && data >= elem) true
      else {
        if(elem < data) {
          if(left != null) left.contains(elem)
          else false
        } else {
          if(right != null) right.contains(elem)
          else false
        }
      }
    }
    def insert(elem:A):Unit = {
      if(elem < data) {
        if(left != null) left.insert(elem)
        else left = new Node(elem, null, null)
      } else {
        if(right != null) right.insert(elem)
        else right = new Node(elem, null, null)
      }
    }
  }

  private var root:Node = null
  def contains(elem:A):Boolean = {
    if(root == null) false
    else root.contains(elem)
  }
  def insert(elem:A):Unit = {
    if(root == null) root = new Node(elem, null, null)
    else root.insert(elem)
  }
  def remove(elem:A):Unit = ???
  def isEmpty():Boolean = { root == null }
}