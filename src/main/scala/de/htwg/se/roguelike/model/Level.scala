package de.htwg.se.roguelike.model

case class Level(map: Land[Tile]) {
  def this(size: Int) = this(new Land[Tile](size, Tile(0)))

  def moveUp(player: Player): (Level,Player) = {
    if (player.posY-1 < 0) {
      return (this,player)
    }

    var player1 = player.copy(posY = player.posY - 1)

    var level = new Level(map.replaceTile(player1.posY,player1.posX,new Tile(5 + map.tile(player1.posY,player1.posX).value)))
    level = new Level(level.map.replaceTile(player.posY,player.posX,new Tile(level.map.tile(player.posY,player.posX).value - 5)))

    (level,player1)
  }

  def moveDown(player: Player): (Level,Player) = {
    if (player.posY+1 > map.size-1) {
      return (this,player)
    }

    var player1 = player.copy(posY = player.posY + 1)

    var level = new Level(map.replaceTile(player1.posY,player1.posX,new Tile(5 + map.tile(player1.posY,player1.posX).value)))
    level = new Level(level.map.replaceTile(player.posY,player.posX,new Tile(level.map.tile(player.posY,player.posX).value - 5)))

    (level,player1)
  }

  def moveLeft(player: Player): (Level,Player) = {
    if (player.posX-1 < 0) {
      return (this,player)
    }

    var player1 = player.copy(posX = player.posX - 1)

    var level = new Level(map.replaceTile(player1.posY,player1.posX,new Tile(5 + map.tile(player1.posY,player1.posX).value)))
    level = new Level(level.map.replaceTile(player.posY,player.posX,new Tile(level.map.tile(player.posY,player.posX).value - 5)))

    (level,player1)
  }

  def moveRight(player: Player): (Level,Player) = {
    if (player.posX+1 > map.size-1) {
      return (this,player)
    }

    var player1 = player.copy(posX = player.posX + 1)

    var level = new Level(map.replaceTile(player1.posY,player1.posX,new Tile(5 + map.tile(player1.posY,player1.posX).value)))
    level = new Level(level.map.replaceTile(player.posY,player.posX,new Tile(level.map.tile(player.posY,player.posX).value - 5)))

    (level,player1)
  }


  override def toString: String = {
    val sb = new StringBuilder
    for (x <- 0 to map.size-1) {
      for (y <- 0 to map.size - 1) {
        sb++=(map.tile(x,y).value + " ")
      }
      sb++=("\n")
    }
    sb.toString
  }
}
