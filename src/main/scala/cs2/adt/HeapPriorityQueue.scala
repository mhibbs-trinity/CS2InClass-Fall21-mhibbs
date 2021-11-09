package cs2.adt

class HeapPriorityQueue[A <% Ordered[A] : Manifest] extends PriorityQueue[A] {
  private var heap = Array.ofDim[A](10)
  private var len = 0

  def add(elem:A):Unit = {
    len += 1

    heap(len) = elem
    if(heap(len/2) < heap(len)) {
      heap(len) = heap(len/2)
      heap(len/2) = elem
    }
  }
  def get():A = ???
  def peek():A = heap(1)
  def isEmpty():Boolean = { len == 0 }
}