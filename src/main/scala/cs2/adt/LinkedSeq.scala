package cs2.adt

class LinkedSeq[A] extends Seq[A] with Iterable[A] {
  private class Node(var data:A, var next:Node) { }

  private var hed:Node = null
  private var len:Int = 0

  def iterator:Iterator[A] = {
    new Iterator[A]() {
      var rover:Node = hed

      def next():A = {
        val ret = rover.data
        rover = rover.next
        ret
      }
      def hasNext:Boolean = rover != null
    }
  }

  private def getNode(idx:Int):Node = {
    var rover = hed
    for(i <- 1 to idx) {
      rover = rover.next
    }
    rover
  }

  def get(idx:Int):A = {
    if(idx >= length || idx < 0) throw new IndexOutOfBoundsException()
    val rover = getNode(idx)
    rover.data
  }
  def set(idx:Int, elem:A):Unit = {
    if(idx >= length || idx < 0) throw new IndexOutOfBoundsException()
    val rover = getNode(idx)
    rover.data = elem
  }
  def insert(idx:Int, elem:A):Unit = {
    if(idx > length || idx < 0) throw new IndexOutOfBoundsException()
    len += 1
    if(length == 0 || idx == 0) {
      hed = new Node(elem, hed)
    } else {
      val rover = getNode(idx-1)
      rover.next = new Node(elem, rover.next)
    }
  }
  def remove(idx:Int):A = {
    if(idx >= length || idx < 0) throw new IndexOutOfBoundsException()
    len -= 1
    if(idx == 0) {
      val ret = hed.data
      hed = hed.next
      ret
    } else {
      val rover = getNode(idx-1)
      val ret = rover.next.data
      rover.next = rover.next.next
      ret
    }
  }
  def length():Int = len
}