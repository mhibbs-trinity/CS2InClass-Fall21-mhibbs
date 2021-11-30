
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

  def main(args:Array[String]):Unit = {
    val logger = new TimeLogger
    logger.reset()
    logger.getTime()

    val num = 250000
    logger.reset()
    //factRecur(num)
    //println(logger.getTime())

    logger.reset()
    factFor(num)
    println(logger.getTime())

    logger.reset()
    factCollect(num)
    println(logger.getTime())
  }
}

