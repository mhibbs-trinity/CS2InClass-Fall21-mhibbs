package cs2.graphics

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.animation.AnimationTimer

object BouncingBall extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "Bounce!"
    scene = new Scene(600,400) {
      val canvas = new Canvas(600,400)
      content = canvas
      val g = canvas.graphicsContext2D

      g.setFill(Color.Red)
      var px:Double = width.value/2
      var py:Double = height.value/2

      val timer = AnimationTimer(t => {
        px -= 0.1
        g.fillOval(px,py, 100,100)
      })
      timer.start


    }
  }
}
