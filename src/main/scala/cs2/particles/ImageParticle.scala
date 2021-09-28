package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

class ImageParticle(p:Vec2,v:Vec2) extends Particle(p,v) {

  private var lifetime:Double = 400.0

  override def display(g:GraphicsContext):Unit = {
    g.globalAlpha = (lifetime / 400.0)  
    g.drawImage(ImageParticle.img, pos.x,pos.y)
    g.globalAlpha = 1.0
  }

  override def timeStep():Unit = {
    super.timeStep()
    lifetime -= 1.0
  }

}

object ImageParticle {
  val path = getClass().getResource("/images/Smoke.png")
  val img = new Image(path.toString())
}

