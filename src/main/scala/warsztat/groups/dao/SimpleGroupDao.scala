package warsztat.groups.dao
import java.util.UUID

import warsztat.groups.domain.Group

import scala.collection.mutable

class SimpleGroupDao extends GroupDao {

  private[this] val groups = mutable.Map.empty[UUID, Group]

  override def saveGroup(group: Group) = ???

  override def addUserToGroup(groupId: UUID, userId: UUID) = ???
}
