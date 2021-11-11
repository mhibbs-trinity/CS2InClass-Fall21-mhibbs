package cs2.adt

abstract class Set[A <% Ordered[A]] extends Iterable[A] {
  def add(elem:A):Unit
  def remove(elem:A):Unit
  def contains(elem:A):Boolean
  def size:Int

  def intersect(other:Set[A]):Set[A] = {
    val res = Set[A]()
    for(x <- this) {
      if(other.contains(x)) res.add(x)
    }
    res
  }
  def union(other:Set[A]):Set[A]
  def difference(other:Set[A]):Set[A]
}

object Set {
  def apply[A <% Ordered[A]]():Set[A] = new BSTSet[A] ()
}
