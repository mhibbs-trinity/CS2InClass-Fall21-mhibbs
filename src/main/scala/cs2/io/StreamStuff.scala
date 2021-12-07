package cs2.io

import java.io._
import java.net.URL
import java.net.ServerSocket
import java.net.Socket

object StreamStuff {

  def copyFile(inname:String, outname:String):Unit = {
    val fis = new BufferedInputStream(new FileInputStream(new File(inname)))
    val fos = new BufferedOutputStream(System.out)//new FileOutputStream(new File(outname)))

    while(fis.available() > 0) {
      val b = fis.read()
      fos.write(b)
    }

    fis.close()
    fos.close()
  }

  def readWebsite(name:String):Unit = {
    val fis = new BufferedInputStream((new URL(name)).openStream())
    val fos = new BufferedOutputStream(System.out)

    println(fis.available())
    while(fis.available() > 0) {
      //println("Hello!")
      //println(fis.read())
      val b = fis.read()
      fos.write(b)
    }

    fis.close()
    fos.close()
  }

  def serverSide():Unit = {
    val ss = new ServerSocket(50000)
    val sock = ss.accept()
    val os = new BufferedOutputStream(sock.getOutputStream())
    for(i <- 1 to 10) {
      val c = scala.util.Random.nextPrintableChar()
      println(">>> Sending " + c)
      os.write(c)
    }
    os.flush()
  }

  def clientSide():Unit = {
    val sock = new Socket("localhost", 50000)
    val is = new BufferedInputStream(sock.getInputStream())
    while(is.available() == 0) Thread.sleep(10)
    while(is.available() > 0) {
      println("<<< Got " + is.read().toChar)
    }
  }

  def createInputThread(sock:Socket):Thread = {
    new Thread {
      override def run():Unit = {
        val is = new BufferedInputStream(sock.getInputStream())
        while(true) {
          while(is.available() == 0) Thread.sleep(10)
          while(is.available() > 0) {
            var c = is.read().toChar
            println("<<< " + c)
          }
        }
      }
    }
  }
  def createOutputThread(sock:Socket):Thread = {
    new Thread {
      override def run():Unit = {
        val os = new BufferedOutputStream(sock.getOutputStream())
        while(true) {
          val line = io.StdIn.readLine()
          for(c <- line) {
            os.write(c)
          }
          os.flush()
        }
      }
    }
  }

  def main(args:Array[String]):Unit = {
    //(new Thread { override def run():Unit = { serverSide() } }).start()
    //Thread.sleep(1000)
    //clientSide()
    //copyFile("sample.txt","copy.txt")
    //println(new URL("http://www.google.com"))
    //readWebsite("https://www.trinity.edu")
    var sock:Socket = null
    if(args(0) == "server") {
      val ss = new ServerSocket(50001)
      sock = ss.accept()
    } else if(args(0) == "client") {
      sock = new Socket(args(1), 50001)
    }

    if(sock != null) {
      val inThread = createInputThread(sock)
      val outThread = createOutputThread(sock)
      inThread.start()
      outThread.start()
      
    }

  }
}