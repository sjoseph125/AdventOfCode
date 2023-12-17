package Day1.part1

object solution extends App{
  import scala.io.Source._
  import scala.util.matching.Regex
  // 12 red cubes, 13 green cubes, and 14 blue cubes
  val contents: Seq[Seq[String]] =fromFile("Solutions/src/main/scala/Day1/part1/data.txt").getLines().toSeq.map(_.split("[;,]").toSeq)
  val pattern: Regex = """(\d+)""".r

  val keys = contents.map(_.head.split(':').head)
  val values = contents.map(x => {
    val top = x.head.split(':').tail
    val bottom = x.tail
    val comb = top ++ bottom
    comb.toSeq
  })
  val gameToSetsMap = keys.zip(values).toMap

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
