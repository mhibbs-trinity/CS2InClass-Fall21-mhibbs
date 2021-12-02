import java.util.concurrent.Executors
import java.util.concurrent.Callable

class TimeLogger {
  var start:Long = System.nanoTime()
  def reset():Unit = start = System.nanoTime()
  def getTime():Double = (System.nanoTime() - start)/1e9
}

object Factorials {

  def factRecur(n:BigInt):BigInt = {
    if(n <= 1) 1
    else n * factRecur(n-1)
  }
  def factFor(n:BigInt):BigInt = {
    var prod:BigInt = 1
    for(x <- BigInt(1) to n) {
      prod *= x
    }
    prod
  }
  def factCollect(n:BigInt):BigInt = {
    (BigInt(1) to n).reduce(_*_)
  }
  def factParCollect(n:BigInt):BigInt = {
    (BigInt(1) to n).reduce(_*_)
  }

  class Lock
  val lock = new Lock
  def factThread(n:BigInt):BigInt = {
    var prod:BigInt = 1
    val numThreads = 10
    val threads = Array.tabulate(numThreads)((idx:Int) => new Thread {
      override def run():Unit = {
        var localProduct:BigInt = 1
        for(x <- BigInt(idx+1) to n by numThreads) localProduct *= x
        lock.synchronized { prod *= localProduct }
      }
    })
    threads.foreach(_.start)
    threads.foreach(_.join)
    prod
  }
  def factExecutor(n:BigInt):BigInt = {
    val service = Executors.newCachedThreadPool()
    val numTasks = 10
    val futures = Array.tabulate(numTasks)((idx:Int) => service.submit(new Callable[BigInt] {
      override def call():BigInt = {
        var localProduct:BigInt = 1
        for(x <- BigInt(idx+1) to n by numTasks) localProduct *= x
        localProduct
      }
    }))
    val ret = futures.map(_.get).product
    service.shutdown()
    ret
  }

  def main(args:Array[String]):Unit = {
    val logger = new TimeLogger
    logger.reset()
    logger.getTime()

    val num = 100
    logger.reset()
    //factRecur(num)
    //println(logger.getTime())

    logger.reset()
    factFor(num)
    println(logger.getTime())

    logger.reset()
    factCollect(num)
    println(logger.getTime())

    logger.reset()
    factThread(num)
    println(logger.getTime())

    logger.reset()
    factExecutor(num)
    println(logger.getTime())
  }
}

