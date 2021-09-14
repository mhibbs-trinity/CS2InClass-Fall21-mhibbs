package cs2.graphics

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas

object FirstWindow extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "My First Window"
    scene = new Scene(600,400) {
      val canvas = new Canvas(600,400)
      content = canvas

      val g = canvas.graphicsContext2D

      g.strokeRect(100,50, 200,100)
      g.fillOval(100,50, 200,100)
      g.strokeLine(0,0, 600,400)
      g.fillText("Hello there!", 300,300)



    }
  }
}


