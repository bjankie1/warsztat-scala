package warsztat

import java.util.UUID

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class Futures {


  def loadUser(id: UUID): Future[Person] = {
    Future {
//      hibernate.load(id)
      scala.concurrent.blocking {
        Thread.sleep(100)
        Person(UUID.randomUUID(), "Tom", UUID.randomUUID())
      }
    }
  }

  def loadGroup(groupId: UUID): Future[Group] = ???


  val groupName: Future[String] = for {
    user <- loadUser(UUID.randomUUID())
    group <- loadGroup(user.groupId)
  } yield {
    group.name
  }

  groupName.onComplete {
    case Success(result) => println(result)
    case Failure(ex) => ex.printStackTrace
  }

}
