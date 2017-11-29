package warsztat

import org.scalatest.{FlatSpec, Matchers}

class StringConversionsTest extends FlatSpec with Matchers {

  it should "convert '123.3' to BigDecimal" in {

    import StringConversions._

    val converter = implicitly[String => BigDecimal]

    val value: BigDecimal = converter("123")

    val number: BigDecimal = "123.3"
    number shouldBe BigDecimal(123.3)
  }

}
