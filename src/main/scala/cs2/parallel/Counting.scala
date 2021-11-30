package cs2.parallel

import io.StdIn._
import java.lang.Thread
import java.util.concurrent.Executors
import java.util.concurrent.Callable
import java.util.concurrent.Future

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

  class Lock

  def countToABillion():Unit = {
    var ctr = 0

    val lock = new Lock

    val threads = Array.fill(8)(new Thread {
      override def run():Unit = {
        var localCtr = 0
        for(i <- 1 to 1000000000 / 8) {
          localCtr += 1
        }
        lock.synchronized {
          ctr += localCtr
        }
      }
    })
    threads.foreach(_.start)
    threads.foreach(_.join)

    println(ctr)
  }

  val lock1 = new Lock
  val lock2 = new Lock

  def funcA():Unit = {
    lock1.synchronized {
      println("A holds 1")
      lock2.synchronized {
        println("A holds 2")
      }
    }
  }
  def funcB():Unit = {
    lock2.synchronized {
      println("B holds 2")
      lock1.synchronized {
        println("B holds 1")
      }
    }
  }
  def tryToDeadlock():Unit = {
    val athreads = Array.fill(5)(new Thread {
      override def run():Unit = { funcA }
    })
    val bthreads = Array.fill(5)(new Thread {
      override def run():Unit = { funcB }
    })
    athreads.foreach(_.start)
    Thread.sleep(100)
    bthreads.foreach(_.start)
  }

  def waitNotify():Unit = {
    var turn = -1

    val threads = Array.tabulate(10)((idx:Int) => new Thread {
      override def run():Unit = {
        println("Thread " + idx + " has started")
        lock1.synchronized {
          while(turn != idx) lock1.wait()

          Thread.sleep(scala.util.Random.nextInt(2000))
          println("Thread " + idx + " has finished")

          turn += 1
          lock1.notifyAll()
        }
      }
    })
    threads.foreach(_.start)
    Thread.sleep(100)
    turn = 0
    lock1.synchronized {
      lock1.notifyAll()
    }
    threads.foreach(_.join)
  }

  def countToABillionWithExecutor():Unit = {
    val service = Executors.newCachedThreadPool()
    val n = 8
    val future:Array[Future[Int]] = Array.fill(n)(service.submit(new Callable[Int] {
      override def call():Int = {
        var localCtr = 0
        for(i <- 1 to 1000000000 / n) {
          localCtr += 1
        }
        localCtr
      }
    }))

    val res:Array[Int] = future.map(_.get)
    println(res.reduce(_+_))
    service.shutdown()
  }



  def main(args:Array[String]):Unit = {
    //println("Hello " + getNameTimeout())
    //for(i <- 1 to 20) {
      countToABillionWithExecutor()
    //}
    //tryToDeadlock()
    //waitNotify()
  }
}



