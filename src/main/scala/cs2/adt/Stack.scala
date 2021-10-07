package cs2.adt

abstract class Stack[A] {
  def push(elem:A):Unit
  def pop():A
  def peek():A //top
  def isEmpty():Boolean
}

object Stack {

  def main(args:Array[String]):Unit = {
    val s:Stack[Int] = new ArrayStack[Int]()
    println(s.isEmpty())
    s.push(5)
    s.push(7)
    s.push(3)
    println(s.pop) //3
    println(s.peek) //7
    println(s.pop) //7
    println(s.isEmpty())
    println(s.pop) //5
  }

}



