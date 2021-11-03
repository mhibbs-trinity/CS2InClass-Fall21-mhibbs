package cs2.algorithms

import scala.util.Random
import cs2.adt.LinkedPriorityQueue

class Golfer(var name: String) extends Ordered[Golfer] {
  var score: Int = 0
  var distToHole: Double = 0

  def inTheHole(): Boolean = distToHole == 0.0
  def readyToTeeOff(dist: Double) { distToHole = dist }
  def hitBall(): Double = {
    score += 1
    var driveLength = 0.0
    if (distToHole < 50) {
      driveLength = distToHole
      distToHole = 0.0
    } else if (distToHole < 150) {
      driveLength = Random.nextDouble * (distToHole - 50) + 50
      distToHole -= driveLength
    } else {
      driveLength = Random.nextDouble() * 50 + 100
      distToHole -= driveLength
    }
    driveLength
  }

  def compare(other: Golfer): Int = { distToHole.compare(other.distToHole) }
}

object GolfingOrders {
  //Quick simulator of playing 3 holes of golf with Kevin Spacey, Kevin Spacey, Kevin Spacey, and Kevin Spacey
  def main(args: Array[String]) {
    val holeDists = Array(145.0, 225.0, 300.0)
    val frank = new Golfer("Frank Underwood")
    val roger = new Golfer("Roger Kent")
    val lex = new Golfer("Lex Luthor")
    val kevin = new Golfer("Kevin Spacey")
    val golfers = Array(frank, roger, lex, kevin)

    val pq = new LinkedPriorityQueue[Golfer]
    for (hole <- 0 until holeDists.length) {
      //Reset each golfer to the next tee by changing their distance to the hole
      golfers.foreach(x => x.readyToTeeOff(holeDists(hole)))
      golfers.foreach(x => pq.add(x))

      println("Now Playing Hole #" + (hole + 1))
      println("Turn\tPlayer       \tLength of Hit   \tStrokes\tDist to Hole")

      //While the PQ still has more players, get the next up player, and have them take a stroke
      var hitCounter = 0
      while (!pq.isEmpty) {
        val curr = pq.get
        val shotLength = curr.hitBall
        println(
          hitCounter + "\t" + curr.name + "\t" + shotLength + "\t" + curr.score + "\t" + curr.distToHole
        )
        if (!curr.inTheHole) pq.add(curr)
        hitCounter += 1
      }
      println
    }
  }
}
