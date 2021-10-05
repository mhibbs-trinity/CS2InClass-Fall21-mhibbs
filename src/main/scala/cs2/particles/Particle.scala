package cs2.particles

import cs2.util.Vec2
import scalafx.scene.paint.Color
import scalafx.scene.canvas.GraphicsContext

abstract class Particle(protected var pos:Vec2, private var vel:Vec2) {
  protected var col:Color = Color.DarkSeaGreen
  protected var rad:Double = 10.0

  //Abstract method
  def display(g:GraphicsContext):Unit

  //Non-abstract (concrete) methods
  def timeStep():Unit = {
    pos += vel
  }
  def applyForce(force:Vec2):Unit = {
    vel += force
  }

  def isAlive():Boolean = {
    true
  }


}