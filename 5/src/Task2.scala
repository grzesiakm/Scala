abstract class Equation(){
  def calculate: Double
}

class EquationSolver {
  var result: Double = 0.0

  def <<(e: Any) : EquationSolver = {
    e match {
      case _: Addition => result += e.asInstanceOf[Equation].calculate
      case _: Subtraction => result -= e.asInstanceOf[Equation].calculate
      case _: Multiplication => result *= e.asInstanceOf[Equation].calculate
      case _: Division =>
        if(e.asInstanceOf[Equation].calculate != 0) {
          result /= e.asInstanceOf[Division].calcSilent
        }
        else {
          println("Unknown / not allowed operation")
        }
      case _ => println("Unknown / not allowed operation")
    }
    this
  }

  override def toString: String = {
    "Result: " + result
  }

}

case class Addition(i: Int) extends Equation {
  override def calculate: Double = {
    println("Adding " + i.toDouble)
    i
  }
}

case class Subtraction(i: Int) extends Equation {
  override def calculate: Double = {
    println("Subtracting " + i.toDouble)
    i
  }
}

case class Multiplication(i: Int) extends Equation {
  override def calculate: Double = {
    println("Multiplying by " + i.toDouble)
    i
  }
}

case class Division(i: Int) extends Equation {
  override def calculate: Double = {
    if(i != 0)
      println("Dividing by " + i.toDouble)
    i
  }
  def calcSilent: Double = {
    i
  }
}


object Task2 {
  def main(args: Array[String]) = {
    val s = new EquationSolver()
    println(s)
    s << Addition(1) << Subtraction(1)
    println(s)
    s << Division(0)
    println(s)
    s << Addition(1) << Multiplication(5)
    println(s)
    s << Division(2)
    println(s)
    s << List[Int](1)
    println(s)
  }

}
