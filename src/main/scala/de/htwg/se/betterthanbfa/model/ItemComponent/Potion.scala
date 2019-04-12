package de.htwg.se.betterthanbfa.model.ItemComponent

import de.htwg.se.betterthanbfa.model.playerComponent.Player

class Potion {

  val r = new scala.util.Random

  var name = Array("Heal", "Mana", "HeavyHeal", "HeavyMana")
  var typ: String = setType()

  var value: Int = 0
  var power: Int = 0

  private def setType() = name(r.nextInt(4))

  def randomPotion(player: Player):Unit = {
    typ match {
      case "Heal" => {
        value = 10
        power = 25
      }
      case "HeavyHeal" => {
        value = 25
        power = 50
      }
      case "Mana" => {
        value = 25
        power = 10
      }
      case "HeavyMana" => {
        value = 100
        power = 30
      }
    }
  }

  override def toString: String = "PotionName: " + typ + "-Potion" +
    "\nPotionValue: " + value +
    "\nPotionPower: " + power

}