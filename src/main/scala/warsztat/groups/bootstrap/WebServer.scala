package warsztat.groups.bootstrap

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.io.StdIn

trait WebServer { self: Api =>

  def start(): Unit = {
    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()

    implicit val executionContext = system.dispatcher

    val bindingFuture = Http().bindAndHandle(routes, "localhost", 8080)

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done

  }

}
