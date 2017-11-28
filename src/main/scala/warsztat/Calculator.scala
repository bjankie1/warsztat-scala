package warsztat

trait NumberLike[T] {

  def plus(n1: T, n2: T): T

}

object NumberOps {

  implicit val intLike  = new NumberLike[Int] {
    override def plus(n1: Int, n2: Int) = n1 + n2
  }

  implicit val stringLike = new NumberLike[String] {
    override def plus(n1: String, n2: String) = (n1.toInt + n2.toInt).toString
  }
}

object Calculator {

  def +[T](n1: T, n2: T)(implicit numberOps: NumberLike[T]) = {
    numberOps.plus(n1, n2)
  }

}
