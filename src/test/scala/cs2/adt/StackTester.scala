package cs2.adt

import org.junit._
import org.junit.Assert._

class StackTester {
  var s:Stack[Int] = null

  @Before def initStack():Unit = {
    s = Stack[Int]()
  }

  @Test def checkIsEmptyWithEmpty():Unit = {
    assertTrue(s.isEmpty())
    s.push(101)
    s.pop()
    assertTrue(s.isEmpty())
    try {
      s.pop()
    }
    catch {
      case e:java.util.EmptyStackException => { 
        assertTrue(true)
      }
      case _ : Throwable => { assertTrue(false) }
    }
  }
  @Test def checkIsEmptyWithNotEmpty():Unit = {
    s.push(101)
    assertTrue(!s.isEmpty())
    s.pop()
    s.push(51)
    s.push(43)
    assertTrue(!s.isEmpty())
  }
  @Test def checkPushPopPeek():Unit = {
    for(i <- 1 to 100) {
      s.push(i)
    }
    assertTrue(!s.isEmpty())
    for(i <- 100 to 1 by -1) {
      assertTrue(s.peek() == i)
      assertTrue(s.pop() == i)
    }
    assertTrue(s.isEmpty())
  }


}