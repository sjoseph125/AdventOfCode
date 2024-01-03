package Day3

import scala.io.Source.fromFile

trait Base {
  val contents: Seq[Seq[String]] = fromFile("Solutions/src/main/scala/Day3/data.txt").getLines().toSeq.map(_.split("[;,]").toSeq)

}
