package warsztat

import org.scalatest.{FlatSpec, Matchers}

class ExercisesTest extends FlatSpec with Matchers {

  it should "merge two lists" in {
    val l1 = List(1, 3, 8, 9)
    val l2 = List(2, 3, 7)
    val result = Exercises.merge(List.empty)(l1, l2)
    result shouldBe List(1, 2, 3, 3, 7, 8, 9)
  }

}
