package Day1

import scala.io.Source._
import scala.util.matching.Regex
trait Base {
  val contents: Seq[Seq[String]] = fromFile("Solutions/src/main/scala/Day1/part1/data.txt").getLines().toSeq.map(_.split("[;,]").toSeq)
  val pattern: Regex = """(\d+)""".r

  val keys = contents.map(_.head.split(':').head)
  val values = contents.map(x => {
    x.head.split(':').tail ++ x.tail
  })
  val gameToSetsMap = keys.zip(values).toMap
}
