package warsztat

import scala.concurrent.{Future, Promise}
import scala.util.Success

class EventHandler {

  val promise = Promise[String]

  def receive(event: String) = {
    promise.complete(Success(event))
  }

  def load(id: String): Future[String] = {
    promise.future
  }

}
