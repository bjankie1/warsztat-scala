package warsztat.actors

import java.util.UUID

import akka.actor.{Actor, Props}
import warsztat.actors.MyActor.{EventResponse, NotFound, ReadEvent, WriteEvent}
import akka.pattern.pipe
import scala.collection.mutable
import scala.concurrent.Future

class MyActor extends Actor {

  private[this] val values = mutable.Map.empty[UUID, String]

  def loadingService(id: UUID): Future[String] = {
    values.get(id) match {
      case Some(value) => Future.successful(value)
      case None => Future.failed(new RuntimeException("Not found"))
    }
  }

  override def receive = {
    case WriteEvent(id, value) =>
      values(id) = value
    case ReadEvent(id) =>
      import context.dispatcher

      val result: Future[String] = loadingService(id)
      val eventResult = result.map(value => EventResponse(id, value))
      val eventResultWithNotFound = eventResult.recover { case _ => NotFound }
      eventResultWithNotFound pipeTo sender()
  }

}

object MyActor {

  def props: Props = Props(classOf[MyActor])

  case class WriteEvent(id: UUID, value: String)
  case class ReadEvent(id: UUID)
  case class DeleteEvent(id: UUID)

  case class EventResponse(id: UUID, value: String)
  case object NotFound

}