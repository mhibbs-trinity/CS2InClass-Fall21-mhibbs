package cs2.parallel

import io.StdIn._
import java.lang.Thread

object Counting {

  def getNameTimeout():String = {
    var haveName = false
    var timesUp = false

    val thread = new Thread {
      override def run():Unit = {
        //Parallel code in here
        var ctr = 1
        while(!haveName && ctr <= 5) {
          println(ctr)
          ctr += 1
          Thread.sleep(1000)
        }
        if(!haveName) {
          println("Times up!")
          timesUp = true
        }
      }
    }
    thread.start()

    var name = "Jerk"
    println("Enter your name:")
    while(!timesUp && !Console.in.ready) {
      Thread.sleep(10)
    }
    if(!timesUp) {
      name = readLine()
      haveName = true
    }
    name
  }

  def countToABillion():Unit = {
    var ctr = 0

    val threads = Array.fill(8)(new Thread {
      override def run():Unit = {
        for(i <- 1 to 1000000000 / 8) {
          ctr += 1
        }
      }
    })
    threads.foreach(_.start)
    threads.foreach(_.join)

    println(ctr)
  }

  def main(args:Array[String]):Unit = {
    //println("Hello " + getNameTimeout())
    for(i <- 1 to 20) {
      countToABillion()
    }
  }
}



