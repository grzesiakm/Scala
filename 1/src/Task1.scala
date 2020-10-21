object Task1 {
  def main(args: Array[String]): Unit = {
    if (args.length != 2) println("Please provide two arguments")
    else if (!(args(0)(0).isLetter && args(1)(0).isLetter)) println("Please provide only letters")
    else {
      var first = args(0)(0).toLower
      var last = args(1)(0).toLower
      if(first > last) {
        var x = first
        first = last
        last = x
      }
      val list = List.range(first, (last + 1).toChar)
      list.foreach(i => println(s"$i"))
    }
  }
}
