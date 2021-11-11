package cs2.adt

class HeapPriorityQueue[A <% Ordered[A] : Manifest] extends PriorityQueue[A] {
  private var heap = Array.ofDim[A](10)
  private var len = 0

  def add(elem:A):Unit = {
    len += 1
    if(len >= heap.length) {
      val tmp = Array.ofDim[A](len * 2)
      for(i <- 1 until len) tmp(i) = heap(i)
      heap = tmp
    }
    heap(len) = elem
    var loc = len
    while(loc > 1 && heap(loc/2) < heap(loc)) {
      heap(loc) = heap(loc/2)
      heap(loc/2) = elem
      loc = loc/2
    }
  }
  def get():A = {
    val ret = heap(1)
    heap(1) = heap(len)
    heap(len) = heap(0)
    len -= 1

    var loc = 1
    var done:Boolean = false
    while(loc*2 <= len && !done) {
      val bigKid = if(2*loc+1 > len || heap(2*loc) > heap(2*loc+1)) 2*loc else 2*loc+1
      if(heap(bigKid) > heap(loc)) {
        val tmp = heap(loc)
        heap(loc) = heap(bigKid)
        heap(bigKid) = tmp
        loc = bigKid
      } else {
        done = true
      }
    }

    ret
  }
  def peek():A = heap(1)
  def isEmpty():Boolean = { len == 0 }
}






