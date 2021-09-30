package cs2.util

class Vec2(var x:Double, var y:Double) extends Ordered[Vec2] {
  def += (other:Vec2):Unit = {
    this.x += other.x
    this.y += other.y
  }

  def compare(other:Vec2):Int = {
    this.x.compare(other.x)
  }

  override def clone():Vec2 = new Vec2(x,y)
}

object Vec2 {
  def apply(toCopy:Vec2):Vec2 = new Vec2(toCopy.x, toCopy.y)
}

