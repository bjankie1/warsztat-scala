package warsztat

import org.scalatest.{FlatSpec, FunSuite, Matchers}

class CalculatorTest extends FlatSpec with Matchers {


  it should "add two ints" in {
    import NumberOps._
    Calculator.+(1, 2) shouldBe 3
  }

  it should "add two strings" in {
    import NumberOps._
    Calculator.+("1", "2") shouldBe "3"
  }

}
