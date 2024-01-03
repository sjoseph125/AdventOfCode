package Day2.part2

import Day2.Base

object Solution extends App with Base{

  val productSum: Int = {
    keys.flatMap(key => {
      Seq(
        findColors(key, "green") *
        findColors(key, "blue") *
        findColors(key, "red")
      )
    })
  }.sum

  def findColors(key: String, color: String) = {
    gameToSetsMap.get(key).get.map(roll => {
      if (roll.contains(color)) roll else null
    }).distinct.filterNot(_ == null).map(i => pattern.findFirstIn(i).get.toInt).max
  }
  println(productSum)
}
