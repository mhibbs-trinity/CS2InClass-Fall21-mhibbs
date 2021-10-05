package cs2.algorithms

import scala.io.Source

object WordStuff {

  def countWords(lines:Iterator[String]):Int = {
    val words = scala.collection.mutable.Set[String]()
    for(line <- lines) {
      words ++= line.toLowerCase().filter((c:Char) => (c.isLetter || c == ' ')).split(" ")
    }
    for(word <- words) {
      println(word)
    }
    words.size
  }

  def freqWords(lines:Iterator[String]):Int = {
    var words = scala.collection.mutable.Map[String,Int]()
    for(line <- lines) {
      val lineWords = line.toLowerCase().filter((c:Char) => (c.isLetter || c == ' ')).split(" ")
      for(lineWord <- lineWords) {
        if(!words.contains(lineWord)) {
          words(lineWord) = 1
        } else {
          words(lineWord) += 1
        }
      }
    }
    val wordsArray = words.toArray
    Sorting.bubbleSort(wordsArray, (l:(String,Int),r:(String,Int)) => l._2 > r._2)
    for(word <- wordsArray) {
      println(word)
    }
    
    words.size
  }

  def main(args:Array[String]):Unit = {
    val path = getClass().getResource("/tempest.txt")
    val input = Source.fromURL(path).getLines()
    //for(c <- input) println(c)
    println(freqWords(input))
  }

}