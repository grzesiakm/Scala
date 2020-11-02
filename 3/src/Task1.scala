import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Task1 {
  def partition(l: List[Integer], predicate: Integer => Boolean) : (List[Integer], List[Integer]) = {
    @tailrec
    def partitionInternal(l: List[Integer], f: (ListBuffer[Integer], ListBuffer[Integer])): (ListBuffer[Integer], ListBuffer[Integer]) = {
      l match {
        case Nil => f
        case head :: tail => val (left, right) = f
          if (predicate(head)) partitionInternal(tail, (left += head, right))
          else partitionInternal(tail, (left, right += head))
      }
    }

    val (leftT, rightF) = partitionInternal(l, (ListBuffer.empty[Integer], ListBuffer.empty[Integer]))
    (leftT.toList, rightF.toList)
  }

  def main(args: Array[String]): Unit = {
    println(partition(l = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), predicate = _ % 2 == 0))
  }
}
