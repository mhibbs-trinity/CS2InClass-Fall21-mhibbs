package cs2.algorithms

object Sorting {

  def bubbleSort[A <% Ordered[A]](a:Array[A]):Unit = {
    for(i <- 0 until a.length) {
      for(j <- 0 until a.length-1-i) {
        if(a(j) > a(j+1)) {
          val tmp = a(j)
          a(j) = a(j+1)
          a(j+1) = tmp
        }
      }
    }
  }

  def bubbleSort[A] (a:Array[A], gt:(A,A)=>Boolean):Unit = {
    for(i <- 0 until a.length) {
      for(j <- 0 until a.length-1-i) {
        if(gt(a(j), a(j+1))) {
          val tmp = a(j)
          a(j) = a(j+1)
          a(j+1) = tmp
        }
      }
    }
  }

  def main(args:Array[String]):Unit = {
    val arr = Array.fill(10)(scala.util.Random.nextPrintableChar())
    println(arr.mkString(", "))
    bubbleSort(arr)
    println(arr.mkString(", "))
  }



}