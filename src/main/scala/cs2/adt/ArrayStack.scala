package cs2.adt

class ArrayStack[A : Manifest] extends Stack[A] {
  var a:Array[A] = Array.ofDim[A](10)
  var len:Int = 0

  override def push(elem:A):Unit = {
    if(len == a.length) {
      val tmp = Array.ofDim[A](len * 2)
      for(i <- 0 until a.length) {
        tmp(i) = a(i)
      }
      a = tmp
    }
    a(len) = elem
    len += 1
    /* Naive approach
    val tmp = Array.ofDim[A](a.length+1)
    tmp(0) = elem
    for(i <- 0 until a.length) {
      tmp(i+1) = a(i)
    }
    a = tmp
    */
  }
  def pop():A = {
    len -= 1
    a(len)
    /* Naive approach
    val tmp = Array.ofDim[A](a.length-1)
    for(i <- 1 until a.length) {
      tmp(i-1) = a(i)
    }
    val result = a(0)
    a = tmp
    result
    */
  }
  def peek():A = { a(len-1) }
  def isEmpty():Boolean = { len == 0 }
}
