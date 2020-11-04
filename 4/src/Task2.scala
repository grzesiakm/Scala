trait HumanComparator{
  def tDistance: Double
  def rightWhereYouAre(): Boolean = tDistance == 0
  def inYourNeighborhood(): Boolean = tDistance > 0 && tDistance < 10
  def farAway(): Boolean = tDistance > 10
  def toHuman: String = {
    var s = "Right where you are"
    if (inYourNeighborhood()) s = "In your neighborhood"
    else if (farAway()) s = "Far away"
    s
  }
}

class Distance(val td: Double) {
  def tDistance: Double = td
}

class TDistance(beg: (Int, Int), end: (Int, Int)){
  val x: Int = end._1 - beg._1
  val y: Int = end._2 - beg._2
  def tDistance: Double = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))
}

class Formatted(val d: Double) extends Distance(d) with HumanComparator{}

object Task2 {
  def main(args: Array[String]): Unit = {
    val x = new Formatted(0.0)
    println(x.toHuman) // Right where you are

    val y = new Formatted(5.0)
    println(y.toHuman) // In your neighborhood

    val z = new Formatted(25.0)
    println(z.toHuman) // Far away
    println(f"${z.rightWhereYouAre()} ${z.inYourNeighborhood()} ${z.farAway()}") // false false true

    val dist = new TDistance((1, 1), (4, 4)) with HumanComparator
    println(dist.toHuman) // In your neighborhood
  }
}

