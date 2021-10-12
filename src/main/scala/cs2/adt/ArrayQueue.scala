package cs2.adt

class ArrayQueue[A : Manifest] extends Queue[A] {
  private var a:Array[A] = Array.ofDim[A](10)
  private var len:Int = 0
  private var beg:Int = 0

  def enqueue(elem:A):Unit = {
    if(len == a.length) {
      val tmp = Array.ofDim[A](len*2)
      for(i <- 0 until len) {
        tmp(i) = a((beg+i) % a.length)
      }
      a = tmp
      beg = 0
    }
    a((beg+len) % a.length) = elem
    len += 1
  }
  def dequeue():A = {
    val tmp = a(beg)
    len -= 1
    beg = (beg + 1) % a.length
    tmp
  }
  def peek():A = a(beg)
  def isEmpty():Boolean = { len == 0 }
}
