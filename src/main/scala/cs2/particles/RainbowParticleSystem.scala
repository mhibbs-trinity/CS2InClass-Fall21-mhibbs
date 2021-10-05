package cs2.particles

import cs2.util.Vec2

class RainbowParticleSystem(o:Vec2) extends ParticleSystem(o) {
  override def addParticle(): Unit = {
    parts +:= new RainbowParticle(origin.clone(), new Vec2(math.random()-0.5, math.random()-0.5))
  }
}