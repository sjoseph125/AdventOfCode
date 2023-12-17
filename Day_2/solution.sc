import scala.io.Source._

val contents = fromFile("C:\\Users\\Samson Joseph\\Desktop\\AdventOfCode\\Day_2\\data.txt").getLines.toSeq

println(contents.head)
val keys = contents.map(_.split(':').head)
val values: Seq[Array[String]] = contents.flatMap(_.split(':').tail.map(_.split(';')))

val map = keys.zip(values).toMap
val a = map.apply("Game 1").head.contains("4 green")
println(map.apply("Game 1"))
//
//var filtered: Seq[Any] = 0
keys.foreach(key=>{
//  println(map.apply(key).head.contains("4 green"))
//  println(map.get("Game 1"))
  val filtered: Array[String] = map.apply(key).collect{
    case record if record.contains("4 green") => record
    case _ => "hey"
  }
  filtered.head.mkString("")
})
//val m1 = Map("geeks" -> 5, "for" -> 3, "cs" -> 2)
//
//// Applying get method
//val result = m1.get("for")
//
//// Displays output
//println(result)

