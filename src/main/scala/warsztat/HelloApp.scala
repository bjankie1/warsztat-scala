package warsztat

import scala.io.StdIn

/**
  * Prosta apka odpowiadająca jak papuga.
  *
  */
object HelloApp extends App {

  @scala.annotation.tailrec
  def readIn(): Unit = {
    val in = StdIn.readLine("Powiedz coś: ")
    if(in.nonEmpty) {
      println(s"Hello $in")
      readIn()
    }
  }

  readIn()

}
