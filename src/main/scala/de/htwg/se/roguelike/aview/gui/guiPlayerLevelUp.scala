package de.htwg.se.roguelike.aview.gui

import de.htwg.se.roguelike.aview.tui.State
import de.htwg.se.roguelike.controller.{Controller, GameStatus}

import scala.swing.{Dimension, Panel}

case class guiPlayerLevelUp(controller: Controller, gui: SwingGui) extends StateGui {
  override def processInputLine(input: String): Unit = {
    input match {
      case "q" =>
      case "1" => controller.lvlUpHealth()
      case "2" => controller.lvlUpMana()
      case "3" => controller.lvlUpAttack()
      case _ =>
        print("Wrong Input!!!")
    }
  }

  override def handle(): Unit = {
    val e = controller.gameStatus
    e match {
      case GameStatus.LOOTENEMY => gui.state = new guiLootEnemy(controller, gui)
      case GameStatus.PLAYERLEVELUP => gui.state = this
      case _ =>
        print("Wrong GameStatus!!!")
    }
  }

  override def drawPanel(SCALE: Int): Panel = {
    new Panel {
      preferredSize = new Dimension(256 * SCALE, 144 * SCALE + 20)
    }
  }
}