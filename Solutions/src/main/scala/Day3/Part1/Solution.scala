package Day3.Part1

import Day3.Base

object Solution extends App with Base{
  println(contents.zipWithIndex.filter(_._2 == 0).head._1.head)
  println(contents.zipWithIndex.filter(_._2 == 1))

}
