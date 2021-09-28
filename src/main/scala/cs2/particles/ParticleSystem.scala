package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class ParticleSystem(protected var origin:Vec2) {
  protected var parts:List[Particle] = Nil

  def addParticle():Unit = {
    /*
                           //Vec2(origin)
    if(math.random() > 0.5)
      parts ::= new SquareParticle(origin.clone(), new Vec2(math.random()-0.5, math.random()-0.5))
    else
      parts ::= new RoundParticle(origin.clone(), new Vec2(math.random()-0.5, math.random()-0.5))
    */
    parts ::= new ImageParticle(origin.clone(), new Vec2(math.random()-0.5, math.random()-0.5))
  }

  def display(g:GraphicsContext):Unit = {
    for(p <- parts) p.display(g)
  }
  def timeStep():Unit = {
    parts.foreach(x => x.timeStep())
  }
  def applyForce(force:Vec2):Unit = {
    parts.foreach(x => x.applyForce(force))
  }


}