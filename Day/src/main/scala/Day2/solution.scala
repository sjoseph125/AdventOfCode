import javax.naming.ldap.LdapName

object Day_2 extends App{
import scala.io.Source._
import scala.util.matching.Regex
// 12 red cubes, 13 green cubes, and 14 blue cubes
  val contents: Seq[Seq[String]] =fromFile("C:\\Users\\Samson Joseph\\Desktop\\AdventOfCode\\Day_2\\data.txt").getLines().toSeq.map(_.split("[;,]").toSeq)
  val pattern: Regex = """(\d+)""".r

  val keys = contents.map(_.head.split(':').head)
  val values = contents.map(x => {
    val top = x.head.split(':').tail
    val bottom = x.tail
    val comb = top ++ bottom
    comb.toSeq
  })
  val maps2 = keys.zip(values).toMap
  val invalidGames: Int = {
    keys diff keys.flatMap(key => {
      maps2.get(key).get.collect {
        case roll if roll.contains("green") => if (pattern.findFirstIn(roll).get.toInt > 13) key
        case roll if roll.contains("red") => if (pattern.findFirstIn(roll).get.toInt > 12) key
        case roll if roll.contains("blue") => if (pattern.findFirstIn(roll).get.toInt > 14) key
      }.distinct
    })
  }.map(i => pattern.findFirstIn(i).get.toInt).sum
  println(invalidGames)
}
