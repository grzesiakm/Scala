object Task1 {
  def add(x: Int, y: Int) = x+y
  def subtract(x: Int, y: Int) = x-y
  def multiply(x:Int, y:Int) = x*y
  def divide(x:Int, y:Int) = x/y

  def solveEquation(equation: String):Int = {
    val array = equation.split(" ")
    val fun:Map[Char, (Int, Int) => Int] = Map('+' -> add, '-' -> subtract, '*' -> multiply, '/' -> divide)
    fun(array(1).charAt(0))(array(0).toInt, array(2).toInt)
//    array(1).charAt(0) match {
//      case '+' => fun('+').apply(array(0).toInt, array(2).toInt)
//      case '-' => fun('-').apply(array(0).toInt, array(2).toInt)
//      case '*' => fun('*').apply(array(0).toInt, array(2).toInt)
//      case '/' => fun('/').apply(array(0).toInt, array(2).toInt)
//    }
  }

  def main(args: Array[String]) = {
    val equation = "2 + 2"
    println(s"Answer: ${solveEquation(equation)}")
  }
}
