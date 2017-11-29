package warsztat.groups.dao

import java.util.UUID

import warsztat.groups.domain.Group

import scala.concurrent.Future

trait GroupDao {

  def saveGroup(group: Group): Future[Unit]

  def addUserToGroup(groupId: UUID, userId: UUID): Future[Unit]

}
