package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class ParticleSystem(private var origin:Vec2) {
  private var parts:List[Particle] = Nil

  def addParticle():Unit = {
    parts ::= new Particle(origin, new Vec2(math.random()*0.1-0.05, math.random()*0.1-0.05))
  }

  def display(g:GraphicsContext):Unit = {
    for(p <- parts) p.display(g)
  }
  def timeStep():Unit = {
    parts.foreach(x => x.timeStep())
  }


}