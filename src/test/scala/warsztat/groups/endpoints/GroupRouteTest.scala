package warsztat.groups.endpoints

import java.util.UUID

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}
import warsztat.groups.bootstrap.{Services, SimpleDaos}

class GroupRouteTest
    extends FlatSpec
    with Matchers
    with ScalatestRouteTest
    with SimpleDaos
    with Services {

  it should "add group" in {
    val endpoint = new GroupRoute(groupService)
    val uuid = UUID.randomUUID().toString
    val request = Get("/groups/" + uuid)
    request ~> endpoint.routes ~> check {
      responseAs[String] shouldBe s"group: $uuid"
    }
  }

}
