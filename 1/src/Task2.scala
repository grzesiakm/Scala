object Task2 {
  def main(args: Array[String]): Unit = {
    var rectangles = List((2, 4), (5, 8), (4, 9))
    rectangles = (23, 46) :: rectangles
    rectangles = rectangles ++ List((12, 7), (14,9))
    val luckyNum = args(0).toInt
    println("1. ")
    printRectangles(rectangles)
    println("2. ")
    val rec2 = checkArea1(rectangles)
    printRectangles(rec2)
    println("3. ")
    val rec3 = checkArea2(rectangles, luckyNum)
    printRectangles(rec3)
  }

  def printRectangles(list: List[(Int, Int)]): Unit = {
      list.foreach(elem => println(f"(${elem._1}, ${elem._2}) => area: ${elem._1 * elem._2 }"))
  }

  def checkArea1(rectangles: List[(Int, Int)]): List[(Int, Int)] = {
    for(elem <- rectangles if elem._2*elem._1 > elem._2) yield elem
  }

  def checkArea2(rectangles: List[(Int, Int)], luckyNum: Int): List[(Int, Int)] = {
    for(elem <- rectangles if elem._2*elem._1 > luckyNum) yield elem
  }
}
