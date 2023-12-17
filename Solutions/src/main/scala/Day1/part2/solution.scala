package Day1.part2

object solution extends App{

  import scala.io.Source._
  import scala.util.matching.Regex

  val contents: Seq[Seq[String]] = fromFile("Solutions/src/main/scala/Day1/part1/data.txt").getLines().toSeq.map(_.split("[;,]").toSeq)
  val pattern: Regex = """(\d+)""".r

  val keys = contents.map(_.head.split(':').head)
  val values = contents.map(x => {
    val top = x.head.split(':').tail
    val bottom = x.tail
    val comb = top ++ bottom
    comb.toSeq
  })
  val gameToSetsMap = keys.zip(values).toMap
  val test = gameToSetsMap.get("Game 1").get.map(roll=>{
    if (roll.contains("green")) roll else null
  }).distinct.filterNot(_ == null)
  val invalidGames: Int = {
    keys.flatMap(key => {
      val green = findColors(key, "green")
      val blue = findColors(key, "blue")
      val red = findColors(key, "red")
      Seq(green * blue * red)
    })
  }.sum

  def findColors(key: String, color: String) = {
    gameToSetsMap.get(key).get.map(roll => {
      if (roll.contains(color)) roll else null
    }).distinct.filterNot(_ == null).map(i => pattern.findFirstIn(i).get.toInt).max
  }
  println(invalidGames)
}
