package Day4
import scala.io.Source.*
import math.*
import scala.util.matching.Regex
trait Base {
  val contents = fromFile("Solutions/src/main/scala/Day4/data.txt").getLines().toSeq.map(_.strip().split(":").toSeq)
  val keys = contents.map(_.head.replaceAll(" ",""))
  val values: Seq[Seq[Set[String]]] = contents.flatMap(_.tail.map(_.split('|'))).map(_.map(_.split(' ').toSet))
  val cardToValMap: Map[String, Seq[Set[String]]] = keys.zip(values).toMap
  val pattern: Regex = """(\d+)""".r
  case class cardSets (
                      cardNum: String,
                      matches: Int,
                      count: Int
                      )
}
