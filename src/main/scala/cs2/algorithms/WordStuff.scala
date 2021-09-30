package cs2.algorithms

import scala.io.Source

object WordStuff {

  def countWords(lines:Iterator[String]):Int = {
    val words = scala.collection.mutable.Set[String]()
    for(line <- lines) {
      words ++= line.split(" ")
    }
    words.size
  }

  def main(args:Array[String]):Unit = {
    val path = getClass().getResource("/tempest.txt")
    val input = Source.fromURL(path).getLines()
    //for(c <- input) println(c)
    println(countWords(input))
  }

}