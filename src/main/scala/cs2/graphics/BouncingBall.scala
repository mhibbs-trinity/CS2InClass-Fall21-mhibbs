package cs2.graphics

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.animation.AnimationTimer
import cs2.util.Vec2
import scalafx.scene.image.Image

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
      //var p:Vec2 = new Vec2(width.value/2, height.value/2)

      var vx:Double = math.random() - 0.5
      var vy:Double = math.random() - 0.5

      val path = getClass().getResource("/images/Star.png")
      val img = new Image(path.toString)

      val timer = AnimationTimer(t => {
        g.setFill(Color.White)
        g.fillRect(0,0, width.value,height.value)
        if(px <= 0 || (px+img.width.value) >= width.value) {
          vx = -vx
        }
        if(py <= 0 || (py+img.height.value) >= height.value) {
          vy = -vy
        }
        
        px += vx
        py += vy
        
        g.setFill(Color.Red)
        //g.fillOval(px,py, 100,100)
        g.drawImage(img, px,py)
      })
      timer.start


    }
  }
}
