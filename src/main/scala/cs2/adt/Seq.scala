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

object Seq {
  def apply[A]():Seq[A] = new LinkedSeq[A]()
  def main(args:Array[String]):Unit = {
    val s = new LinkedSeq[Char]()
    s.insert(0, 'A')
    s.insert(0, 'B')
    s.insert(0, 'C')
    s.insert(0, 'D')
    s.remove(2)
    for(i <- 0 until s.length()) {
      print(s.get(i) + ",")
    }
    println()

    var it = s.iterator
    while(it.hasNext) {
      print(it.next + ",")
    }
    println()

    it = s.iterator
    println(it.map(c => (c+1).toString*2).mkString(","))

    println(s.mkString("!#!"))
    for(x <- s) println(x)

  }
}




