package warsztat

import org.scalatest.{FlatSpec, Matchers}

class RichByteArrayTest extends FlatSpec with Matchers {

  it should "render byte array" in {
    import warsztat.RichByteArray.RichByteArray
    val in = "some data"
    in.getBytes.render("|") shouldBe s"|$in"
  }

}
