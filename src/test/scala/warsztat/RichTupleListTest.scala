package warsztat

import org.scalatest.{FlatSpec, Matchers}

class RichTupleListTest extends FlatSpec with Matchers {

  import RichTupleList.RichTupleList

  it should "apply map values method" in {
    val simpleList = List((1, 2), (2, 3))
    val result = simpleList.mapValues(_.toString)
  }

}
