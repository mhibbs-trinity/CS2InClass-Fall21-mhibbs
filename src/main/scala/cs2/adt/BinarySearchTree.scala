package cs2.adt

import scalafx.scene.input.KeyCode

class BinarySearchTree[A <% Ordered[A]] extends Iterable[A] {
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
    def getMax():A = {
      if(right == null) data
      else right.getMax()
    }
    def passUpMaxKid():(A,Node) = {
      if(right == null) (data, left)
      else {
        val (d,n) = right.passUpMaxKid()
        right = n
        (d, this)
      }

    }
    def remove(elem:A):Node = {
      if(data >= elem && data <= elem) { //if equal
        if(left == null) right
        else if(right == null) left
        else {
          val (d,n) = left.passUpMaxKid()
          left = n
          data = d
          this
        }
      } else {
        if(elem < data) left = left.remove(elem)
        else right = right.remove(elem)
        this
      }
    }

  }

  private var root:Node = null

  def iterator:Iterator[A] = {
    new Iterator[A] {
      val stk = Stack[Node]()
      var n:Node = root
      stk.push(root)
      
      def next():A = {
        n = stk.pop()
        val ret = n.data
        if(n.right != null) stk.push(n.right)
        if(n.left != null) stk.push(n.left)
        ret
      }
      def hasNext:Boolean = {
        !stk.isEmpty
      }
    }
  }
  /*
  val stk = Stack[Node]()
  stk.push(root)
  while(!stk.isEmpty()) {
    val n = stk.pop()
    if(n != null) {
      print(n.data + ",")
      stk.push(n.right)
      stk.push(n.left)
    }
  }
  */

  def contains(elem:A):Boolean = {
    if(root == null) false
    else root.contains(elem)
  }
  def insert(elem:A):Unit = {
    if(root == null) root = new Node(elem, null, null)
    else root.insert(elem)
  }
  def remove(elem:A):Unit = {
    if(root != null) root = root.remove(elem)
  }
  override def isEmpty:Boolean = { root == null }

  def getMax():A = {
    root.getMax()
  }
  def removeMax():A = {
    val (d,n) = root.passUpMaxKid()
    root = n
    d
  }

  def printPreOrder():Unit = {
    def processNode(n:Node):Unit = {
      if(n != null) {
        print(n.data + ",")
        processNode(n.left)
        processNode(n.right)
      }
    }
    processNode(root)
    println()
  }
  def printInOrder():Unit = {
    def processNode(n:Node):Unit = {
      if(n != null) {
        processNode(n.left)
        print(n.data + ",")
        processNode(n.right)
      }
    }
    processNode(root)
    println()
  }
  def printPostOrder():Unit = {
    def processNode(n:Node):Unit = {
      if(n != null) {
        processNode(n.left)
        processNode(n.right)
        print(n.data + ",")
      }
    }
    processNode(root)
    println()
  }

  def printPreOrderStack():Unit = {
    val stk = Stack[Node]()
    stk.push(root)
    while(!stk.isEmpty()) {
      val n = stk.pop()
      if(n != null) {
        print(n.data + ",")
        stk.push(n.right)
        stk.push(n.left)
      }
    }
    println
  }

}

object BSTTester {
  def main(args:Array[String]):Unit = {
    val bst = new BinarySearchTree[Int]()
    bst.insert(40)
    bst.insert(20)
    bst.insert(60)
    bst.insert(10)
    bst.insert(15)
    bst.insert(50)
    bst.insert(45)
    bst.insert(47)
    bst.printPreOrder()
    bst.printInOrder()
    bst.printPostOrder()
    bst.printPreOrderStack()
    val it = bst.iterator
    while(it.hasNext) { println(it.next) }
    for(x <- bst) print (x + ",")
  }
}



