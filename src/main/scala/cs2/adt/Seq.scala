package cs2.adt

abstract class Seq[A] {
  //Abstract methods
  def get(idx:Int):A
  def set(idx:Int, elem:A):Unit
  def insert(idx:Int, elem:A):Unit
  def remove(idx:Int):A
  def length():Int

  //Derived concrete methods
  def prepend(elem:A):Unit = insert(0,elem)
  def +:= (elem:A):Unit = prepend(elem)
  def append(elem:A):Unit = insert(length, elem)
  def += (elem:A):Unit = append(elem)

  def apply(idx:Int):A = get(idx)
  def update(idx:Int, elem:A) = set(idx, elem)
}

