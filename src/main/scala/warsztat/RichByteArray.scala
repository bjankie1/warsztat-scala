package warsztat

object RichByteArray {
  implicit class RichByteArray(ba: Array[Byte]) {

    def render(prefix: String): String = {
      prefix + new String(ba)
    }

  }

}
