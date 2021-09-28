package cs2.particles

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import cs2.util.Vec2
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent

object ParticleSystemApp extends JFXApp with Rainbowness {
  stage = new JFXApp.PrimaryStage {
    title = "Particles!"
    scene = new Scene(800,600) {
      val canvas = new Canvas(800,600)
      content = canvas
      val g = canvas.graphicsContext2D

      var ps:List[ParticleSystem] = List()
      val gravity = new Vec2(0,0.001)
      val updraft = new Vec2(0,-0.005)

      canvas.onMouseClicked = (e:MouseEvent) => {
        ps ::= new ParticleSystem(new Vec2(e.x, e.y))
      }
      var windSpeed:Double = 0.0
      canvas.onMouseMoved = (e:MouseEvent) => {
        windSpeed = e.x / width.value * 0.02 - 0.01
      }

      val timer = AnimationTimer(t => {
        g.setFill(stepColor())
        g.fillRect(0,0, width.value,height.value)

        for(p <- ps) {
          p.display(g)
          p.timeStep()
          p.addParticle()
          p.applyForce(updraft)
          p.applyForce(new Vec2(windSpeed,0.0))
        }
      })
      timer.start

    }
  }

}