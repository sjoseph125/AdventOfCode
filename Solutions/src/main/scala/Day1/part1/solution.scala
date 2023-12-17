package Day1.part1

import Day1.Base

object solution extends App with Base{

  val invalidGames = {
    keys diff keys.flatMap(key => {
      gameToSetsMap.get(key).get.collect {
        case roll if roll.strip().contains("green") => if (pattern.findFirstIn(roll).get.toInt > 13) key else null
        case roll if roll.strip().contains("red") => if (pattern.findFirstIn(roll).get.toInt > 12) key else null
        case roll if roll.strip().contains("blue") => if (pattern.findFirstIn(roll).get.toInt > 14) key else null
      }.distinct.filterNot(_ == null)
    })
  }.map(i => pattern.findFirstIn(i).get.toInt).sum
  println(invalidGames)
}
