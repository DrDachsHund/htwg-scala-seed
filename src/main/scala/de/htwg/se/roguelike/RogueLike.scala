package de.htwg.se.roguelike

import de.htwg.se.roguelike.aview._
import de.htwg.se.roguelike.controller.Controller
import de.htwg.se.roguelike.model.{Enemy, Level, Player}

import scala.io.StdIn.readLine

object RogueLike {

  val controller = new Controller(player = Player(name = "Player", posX = 5, posY = 5)
    , enemies = Vector(Enemy(name = "TestE1"),
      Enemy(name = "TestE2", posX = 1),
      Enemy(name = "TestE3", posY = 1)),
    level = new Level(10))
  var tui: Tui = new Tui(controller)

  controller.notifyObservers()


  def main(args: Array[String]): Unit = {
    var input: String = ""
    if (args.length != 0) {
      input = args(0)
    }
    if (!input.isEmpty) tui.state.processInputLine(input)
    else do {
      input = readLine()
      tui.state.processInputLine(input)
    } while (input != "q")
  }
}
