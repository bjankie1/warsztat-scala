package warsztat

import scala.annotation.tailrec

object Exercises {

  @tailrec
  def merge(agg: List[Int])
           (l1: List[Int], l2: List[Int]): List[Int] = {
    (l1, l2) match {
      case (h1 :: tail1, h2 :: tail2) if h1 > h2 =>
        merge(agg :+ h2)(l1, tail2)
      case (h1 :: tail1, h2 :: tail2) if h1 <= h2 =>
        merge(agg :+ h1)(tail1, l2)
      case (tail1, tail2) =>
        agg ++ tail1 ++ tail2
    }
  }

  def binaryString(i: Int, n: Int, k: Int): Int = {
    val bs = i.toBinaryString
    if(n == 0) {
      bs(k).toInt
    } else {
      val result = bs.flatMap {
        case '0' => "01"
        case '1' => "10"
      }
      binaryString(result.toInt, n - 1, k)
    }

  }

}
