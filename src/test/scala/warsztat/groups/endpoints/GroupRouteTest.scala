package warsztat.groups.endpoints

import java.util.UUID

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}
import warsztat.groups.bootstrap.{Services, SimpleDaos}

class GroupRouteTest
    extends FlatSpec
    with Matchers
    with ScalatestRouteTest {

  it should "add group" in {
    val services = new SimpleDaos with Services
    val endpoint = new GroupRoute(services.groupService)
    val uuid = UUID.randomUUID().toString
    val request = Get("/groups/" + uuid)
    request ~> endpoint.routes ~> check {
      responseAs[String] shouldBe s"group: $uuid"
    }
  }

  it should "start another test" in {
    true shouldBe true
  }

}
