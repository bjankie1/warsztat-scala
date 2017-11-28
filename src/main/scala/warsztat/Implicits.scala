package warsztat

import scala.concurrent.duration.{DurationInt, FiniteDuration}

class Implicits {

  implicit val TIMEOUT: FiniteDuration = 2 seconds

  def execute(id: String)
             (implicit timeout: FiniteDuration): Option[String] = ???

  val result = execute("1")

}
