object Task2 {
  def isInside(leftBottomCorner: (Int, Int), rightTopCorner: (Int, Int), point: (Int, Int)): Boolean =
    point._1 >= leftBottomCorner._1 && point._2 >= leftBottomCorner._2 && point._1 <= rightTopCorner._1 && point._2 <= rightTopCorner._2

  @scala.annotation.tailrec def calculatePoints(a: (Int, Int), b: (Int, Int), points: List[(Int, Int)], counter: Int = 0): Int = {
    if (points.isEmpty)
      counter
    else {
      val newCounter = counter + (if (isInside(a, b, points.head)) 1 else 0)
      calculatePoints(a, b, points.drop(1), newCounter)
    }
  }

  def main(args: Array[String]): Unit = {
    val a = (0, 0)
    val b = (10, 10)
    val points = List(a, b, (1, 1), (11, 0), (0, 11))
    println("Number of points inside rectangle is " + calculatePoints(a, b, points) + ".")
  }
}
