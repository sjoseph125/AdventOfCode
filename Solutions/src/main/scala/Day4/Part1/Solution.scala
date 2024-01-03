package Day4.Part1

import Day4.Base

object Solution extends App with Base{

  println(keys)
  println(cardToValMap("Card2"))

  val i: Seq[Int] = keys.map(key => {
    val winningNums = cardToValMap(key).head
    val results = cardToValMap(key).tail.head
    val i: Int = winningNums.intersect(results).filterNot(_ == "").map(_.toInt).toSeq.length
    math.pow(2, i-1).toInt
  })
  println(i.sum)


}
