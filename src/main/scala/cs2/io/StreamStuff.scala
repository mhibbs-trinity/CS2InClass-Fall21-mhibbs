package cs2.io

import java.io._

object StreamStuff {

  def copyFile(inname:String, outname:String):Unit = {
    val fis = new BufferedInputStream(new FileInputStream(new File(inname)))
    val fos = new BufferedOutputStream(new FileOutputStream(new File(outname)))

    while(fis.available() > 0) {
      val b = fis.read()
      fos.write(b)
    }

    fis.close()
    fos.close()
  }


  def main(args:Array[String]):Unit = {
    copyFile("sample.txt","copy.txt")
  }
}