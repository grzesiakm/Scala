abstract class McSet() {
  def name: String
  def price: Double
}

class NormalMcSet() extends McSet {
  override def name: String = "McSet with "
  override def price: Double = 0.0
}

class LargeMcSet() extends McSet {
  override def name: String = "Large McSet with "
  override def price: Double = 0.0
}

trait BigMac extends McSet {
  override abstract def name: String = super.name + "BigMac "
  override abstract def price: Double = super.price + 10.0
}

trait McWrap extends McSet {
  override abstract def name: String = super.name + "McWrap "
  override abstract def price: Double = super.price + 9.0
}

trait Fries extends McSet {
  override abstract def name: String = this match {
    case _: NormalMcSet => super.name + "normal Fries "
    case _ => super.name + "large Fries "
  }
  override abstract def price: Double = this match {
    case _: LargeMcSet => super.price + 5.0*1.5
    case _ => super.price + 5.0
  }
}

trait Coke extends McSet {
  override abstract def name: String = this match {
    case _: NormalMcSet => super.name + "normal Coke "
    case _ => super.name + "large Coke "
  }
  override abstract def price: Double = this match {
    case _: LargeMcSet => super.price + 4.0*1.5
    case _ => super.price + 4.0
  }
}


object Task1 {
  def main(args: Array[String]): Unit = {
    val firstMcSet = new NormalMcSet with BigMac with Fries with Coke
    val firstMcSetLarge = new LargeMcSet with BigMac with Fries with Coke
    val secondMcSet = new LargeMcSet with McWrap with Fries

    println(firstMcSet.name + " " + firstMcSet.price)
    println(firstMcSetLarge.name + " " + firstMcSetLarge.price)
    println(secondMcSet.name + " " + secondMcSet.price)
  }
}
