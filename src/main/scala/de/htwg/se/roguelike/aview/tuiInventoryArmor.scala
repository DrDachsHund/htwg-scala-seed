package de.htwg.se.roguelike.aview

import de.htwg.se.roguelike.controller.{Controller, GameStatus}

class tuiInventoryArmor(controller: Controller, tui: Tui) extends State {
  override def processInputLine(input: String): Unit = {
    input match {
      case "x" => controller.setGameStatus(GameStatus.INVENTORY)
      case "H" => controller.unEquipHelmet()
      case "C" => controller.unEquipChest()
      case "P" => controller.unEquipPants()
      case "B" => controller.unEquipBoots()
      case "G" => controller.unEquipGloves()
      case "q" =>
      case _ =>
        input.toList.filter(c => c != ' ').filter(_.isDigit).map(c => c.toString.toInt) match {
          case index :: Nil => controller.equipArmor(index)
          case _ =>
        }
    }
    handle()
  }

  override def handle(): Unit = {
    val e = controller.gameStatus
    e match {
      case GameStatus.INVENTORYARMOR => tui.state = this
      case GameStatus.INVENTORY => tui.state = new tuiInventoryMain(controller, tui)
      case _ =>
        print("Wrong GameStatus!!!")
    }
  }
}