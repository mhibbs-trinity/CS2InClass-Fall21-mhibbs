package cs2.particles

import cs2.util.Vec2
import scalafx.scene.paint.Color
import scalafx.scene.canvas.GraphicsContext

class Particle(private var pos:Vec2, private var vel:Vec2) {
  private var col:Color = Color.DarkSeaGreen
  private var rad:Double = 10.0

  def display(g:GraphicsContext):Unit = {
    g.setFill(col)
    g.fillOval(pos.x,pos.y, rad*2,rad*2)
  }

  def timeStep():Unit = {
    pos += vel
  }

}