package warsztat

object RichTupleList {

  implicit class RichTupleList[V](l: List[(_, V)]) {

    def mapValues[R](f: V => R): List[R] = {
      l.map(item => f(item._2))
    }

  }

}
