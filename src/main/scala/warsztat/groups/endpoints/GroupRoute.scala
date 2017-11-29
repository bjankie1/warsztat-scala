package warsztat.groups.endpoints

import java.util.UUID

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import warsztat.groups.domain.Group
import warsztat.groups.services.GroupService
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol
import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._


trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {

  implicit object UuidJsonFormat extends JsonFormat[UUID] {
    def write(x: UUID) = JsString(x toString ())
    def read(value: JsValue) = value match {
      case JsString(x) => UUID.fromString(x)
      case x => deserializationError("Expected UUID as JsString, but got " + x)
    }
  }

  implicit val groupFormat = jsonFormat3(Group)
}

class GroupRoute(groupService: GroupService) extends JsonSupport {

    val routes =
    path("/groups") {
      get {
        ???
      } ~
      post {
        entity(as[Group]) { group =>
          onComplete(groupService.addGroup(group)) { _ =>
            complete("ok")
          }
        }

      }
    }

}
