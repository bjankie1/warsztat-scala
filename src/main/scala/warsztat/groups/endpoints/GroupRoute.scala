package warsztat.groups.endpoints

import akka.http.scaladsl.server.Directives._
import warsztat.groups.services.GroupService

class GroupRoute(groupService: GroupService) {

  val routes =
    path("/groups") {
      get {
        ???
      } ~
      post {
        ???
      }
    }

}
