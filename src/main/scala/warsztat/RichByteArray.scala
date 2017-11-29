package warsztat

import java.io.OutputStream

import scala.util.Try

object RichByteArray {
  implicit class RichByteArray(ba: Array[Byte]) {

    def render(prefix: String): String = {
      prefix + new String(ba)
    }

    def writeTo(in: OutputStream): Try[Unit] = ???

  }

}
