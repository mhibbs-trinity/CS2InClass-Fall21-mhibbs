package cs2.particles

import scalafx.scene.paint.Color

trait Rainbowness {
  private var hue:Double = 0.0

  protected def stepColor():Color = {
    hue += 0.3
    Color.hsb(hue, 0.8,0.8)
  }
}