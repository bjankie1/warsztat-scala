package warsztat.web

import akka.http.scaladsl.server.{Directives, Route}

/**
  * Pliki statyczne.
  */
class Site extends Directives {

  val route: Route = getFromResourceDirectory("html")
}