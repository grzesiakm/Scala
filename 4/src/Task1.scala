class SDistance(val kilometers: Int = 0, val meters: Int = 0, val centimeters: Int = 0){
  override def toString: String = s"Kilometers: ${this.kilometers}, Meters: ${this.meters}, Centimeters: ${this.centimeters}"
  def toCm: Int = kilometers * 100_000 + meters * 100 + centimeters
  def add(i: Int, distance: SDistance.Value): SDistance = {
    if (distance == SDistance.Kilometers)
      SDistance.apply(kilometers + i, meters, centimeters)
    else if (distance == SDistance.Meters){
      SDistance.apply(kilometers, meters + i, centimeters)
    }
    else {
      SDistance.apply(kilometers, meters, centimeters + i)
    }
  }
  def >(distance: SDistance): Boolean = this.toCm > distance.toCm
  def <(distance: SDistance): Boolean = this.toCm < distance.toCm
  def ==(distance: SDistance): Boolean = this.toCm == distance.toCm
  def !=(distance: SDistance): Boolean = this.toCm != distance.toCm

}
object SDistance extends Enumeration {
  val Kilometers, Meters, Centimeters = Value
  def apply() = new SDistance()
  def apply(kilometers: Int, meters: Int, centimeters: Int) = new SDistance(kilometers, meters, centimeters)
}

object Task1 {
  def main(args: Array[String]): Unit = {
    val firstDistance = SDistance(2, 2, 2)
    val secondDistance = SDistance(2, 2, 2)
    val thirdDistance = SDistance(2, 2, 3)
    val fourthDistance = SDistance(2, 2, 1)

    println("Distances:")
    println(firstDistance) // Kilometers: 2, Meters : 2, Centimeters: 2
    println(secondDistance) // Kilometers: 2, Meters : 2, Centimeters: 2
    println(thirdDistance) // Kilometers: 2, Meters : 2, Centimeters: 3
    println(fourthDistance) // Kilometers: 2, Meters : 2, Centimeters: 1

    println("2:")
    println(firstDistance == secondDistance) // true
    println(firstDistance != secondDistance) // false
    println(firstDistance > secondDistance) // false
    println(firstDistance < secondDistance) // false

    println("3:")
    println(firstDistance == thirdDistance) // false
    println(firstDistance != thirdDistance) // true
    println(firstDistance > thirdDistance) // false
    println(firstDistance < thirdDistance) // true

    println("4:")
    println(firstDistance == fourthDistance) // false
    println(firstDistance != fourthDistance) // true
    println(firstDistance > fourthDistance) // true
    println(firstDistance < fourthDistance) // false

    val fifthDistance = firstDistance.add(2, SDistance.Meters) // here you have to be able to add also meters or centimeters
    println(fifthDistance) // Kilometers: 4, Meters: 2, Centimeters: 2
  }
}
