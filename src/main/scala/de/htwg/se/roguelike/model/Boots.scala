package de.htwg.se.roguelike.model

case class Boots(name:String,
                 value: Int,
                 usable: Boolean,
                 armor:Int,
                 armorType:String = "Boots",
                 rarity: String) extends Armor {}
