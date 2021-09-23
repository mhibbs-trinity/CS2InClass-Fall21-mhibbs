package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

class SquareParticle(p:Vec2, v:Vec2) extends Particle(p,v) {
  col = Color.OrangeRed

  override def display(g:GraphicsContext):Unit = {
    g.setFill(col)
    g.fillRect(pos.x,pos.y, rad*2,rad*2)
  }

}