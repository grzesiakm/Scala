class ToDoItem(var name: String, var date: String, var done: Boolean = false){
  override def toString: String = s"${name} - till ${date} | DONE: ${done}"
  def checkDone = done = true
}

class ToDoList() {
  var l : List[ToDoItem] = List()

  override def toString: String = l.foreach(elem =>  println(s"${elem.toString}")).toString

  def +(it: ToDoItem) = {
    l  = it :: l
  }

  def markAsDone(i: Int) = {
    l(i).checkDone
    l = l.filter(_.done == false)
  }
}

object Task2 {

  def main(args: Array[String]) = {
    val toDoList = new ToDoList()

    toDoList + new ToDoItem("Clean carpet", "2020-11-01")
    toDoList + new ToDoItem("Wash dishes", "2020-11-02")
    toDoList + new ToDoItem("Learn Scala and be professional with it", "2020-10-28")

    println(toDoList)

    // Prints list of all three ToDoItems nicely formatted, each in separate line

    toDoList.markAsDone(0)

    println(toDoList)

    // Prints list of two ToDoItems without the first one
  }
}
