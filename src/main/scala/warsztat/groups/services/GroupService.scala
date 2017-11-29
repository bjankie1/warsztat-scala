package warsztat.groups.services

import java.util.UUID

import warsztat.groups.dao.GroupDao
import warsztat.groups.domain.Group

import scala.concurrent.Future

class GroupService(groupDao: GroupDao) {

  def addGroup(group: Group): Future[Unit] = ???

  def addUserToGroup(groupId: UUID, userId: UUID): Future[Unit] = ???

}
