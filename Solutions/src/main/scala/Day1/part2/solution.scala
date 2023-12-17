package Day1.part2

import Day1.Base

object solution extends App with Base{

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
