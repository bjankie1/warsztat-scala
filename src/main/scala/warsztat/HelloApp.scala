package warsztat

import java.util.UUID

import scala.annotation.tailrec
import scala.collection.immutable
import scala.util.{Success, Try}


case class Person(id: UUID, name: String, groupId: UUID)

case class Group(id: UUID, name: String, scope: String)

trait MyBehaviour {

  type UserList = List[String]

}


trait MyBehaveLike {

  type ItemType

  def loadItems: List[ItemType]
}

class MyClass extends MyBehaveLike {

  override type ItemType = String

  override def loadItems = ???
}

object HelloApp extends App {

  def loadUser(userId: UUID): Try[Person] = ???

  def loadGroup(groupId: UUID): Try[Group] = ???

  def usersGroupName(): Try[String] = {
    for {
      user <- loadUser(UUID.randomUUID())
      group <- loadGroup(user.groupId)
    } yield {
      group.name
    }
  }



}