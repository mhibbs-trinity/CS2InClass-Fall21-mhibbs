package cs2.graphics

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode

object FirstWindow extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "My First Window"
    scene = new Scene(600,400) {
      val canvas = new Canvas(600,400)
      content = canvas

      val g = canvas.graphicsContext2D
      /*
      g.setFill(Color.rgb(255,255,0))
      g.strokeRect(100,50, 200,100)
      g.fillOval(100,50, 200,100)

      g.setStroke(Color.rgb(50,100,250))
      g.setLineWidth(1)

      g.strokeLine(0,0, 600,400)
      g.setFill(Color.Snow)
      g.fillText("Hello there!", 300,300)

      for(x <- 0 until width.value.toInt by 1) {
        g.setFill(Color.rgb((x/600.0*255).toInt, 0, 0))
        g.fillRect(x,0, 1,height.value)
      }
      */

      canvas.requestFocus()
      g.setStroke(Color.DarkGreen)
      canvas.onMouseDragged = (e:MouseEvent) => {
        g.strokeLine(width.value/2,height.value/2, e.x,e.y)
      }
      canvas.onKeyPressed = (e:KeyEvent) => {
        if(e.code == KeyCode.Space) {
          g.fillRect(0,0, width.value,height.value)
        } else if(e.code == KeyCode.P) {
          g.setStroke(Color.Purple)
        } else if(e.code == KeyCode.R) {
          g.setStroke(Color.Red)
        }
      }
     


    }
  }
}


