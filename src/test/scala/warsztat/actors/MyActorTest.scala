package warsztat.actors

import java.util.UUID

import akka.actor.{ActorRef, ActorSystem}
import akka.pattern._
import akka.testkit.{ImplicitSender, TestKitBase}
import akka.util.Timeout
import org.scalatest.{AsyncFlatSpec, FlatSpec, Matchers}
import warsztat.actors.MyActor.{EventResponse, NotFound, ReadEvent, WriteEvent}

import scala.concurrent.duration.DurationDouble

class MyActorTest
    extends AsyncFlatSpec
    with TestKitBase
    with Matchers
    with ImplicitSender {

  override implicit lazy val system: ActorSystem = ActorSystem("test-system")

  it should "write a message" in {
    val myActorRef: ActorRef = system.actorOf(MyActor.props)

    val id = UUID.randomUUID()
    myActorRef ! WriteEvent(id, "test")
    myActorRef ! ReadEvent(id)
    val response = expectMsgType[EventResponse]

    response shouldBe EventResponse(id, "test")
  }

  it should "write a message and wait for future" in {
    val myActorRef: ActorRef = system.actorOf(MyActor.props)
    implicit val timeout: Timeout = Timeout(1 second)
    val response = myActorRef ? ReadEvent(UUID.randomUUID())

    response.map { value =>
      value shouldBe NotFound
    }
  }

}
