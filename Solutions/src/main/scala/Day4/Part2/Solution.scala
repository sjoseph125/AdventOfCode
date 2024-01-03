package Day4.Part2

import Day4.Base

import javax.naming.ldap.LdapName
import scala.annotation.tailrec
object Solution extends App with Base{
  val initial = keys.length - 1
  val i: Seq[cardSets] = keys.map(key => {
    val winningNums = cardToValMap(key).head
    val results = cardToValMap(key).tail.head
    val i: Int = winningNums.intersect(results).filterNot(_ == "").map(_.toInt).toSeq.length
    cardSets(key, i, 1)

  })
  def counter(input: cardSets, pos: Int, t: Seq[cardSets]): Seq[cardSets] = {
    if(pos>initial) t else{
      val matchesRange = Range.inclusive(-1, input.matches, 1).toList.filter(_<223).tail.take(input.matches)
      val cardCountRange = Range.inclusive(0, input.count,1)

      def loopCardCounts(cardCount: Int, newMiddle: Seq[cardSets]): Seq[cardSets] = {
        if (cardCount == 0) newMiddle else {
          val updatedMid: Seq[cardSets] = matchesRange.map(matchesPos => {
            newMiddle(matchesPos).copy(count = newMiddle(matchesPos).count + 1)

          })
          loopCardCounts(cardCount - 1, updatedMid)
        }
      }
      val updatedSeq = if(input.matches>0) {
        val firstPart = t.splitAt(pos + 1)._1
        val middle = t.splitAt(pos + 1)._2.take(input.matches)
        val end = t.splitAt(pos + 1)._2 diff middle

         val newMiddle = loopCardCounts(input.count, middle)
        firstPart ++ newMiddle ++ end
      }else t
      if(pos <= 221) counter(updatedSeq(pos + 1), pos + 1, updatedSeq) else updatedSeq
    }
  }
  val finalSeq = counter(i(0), 0, i)
  println(finalSeq.map(_.count).sum)

  }

